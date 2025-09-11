public class Task2{
    // This class is used to calculate the sum of an array of integers using multiple threads.
    private static class SumThread extends Thread{
        //Variables for the array, start and end indices, and the partial sum
        private final int[] numbers;
        private final int start;
        private final int end;
        private int partialSum;

        //Constructor
        public SumThread(int[] numbers, int start, int end){
            this.numbers = numbers;
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        //Run method to calculate the partial sum
        @Override
        public void run(){
            for (int i = start; i < end; i++) {
                partialSum += numbers[i];
            }
        }

        //Getter
        public int getPartialSum(){ return partialSum; }
    }

    //Main
    public static void main(String[] args){
        //Variable for the size of the array
        int arraySize = 100000;

        // Create an array of random integers
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            numbers[i] = (int) (Math.random() * 100);
        }

        // Determine the number of available processors and create threads
        int numCores = Runtime.getRuntime().availableProcessors();
        int portionSize = arraySize / numCores;
        SumThread[] threads = new SumThread[numCores];
        for (int i = 0; i < numCores; i++){
            int start = i * portionSize;
            int end = (i == numCores - 1) ? arraySize : start + portionSize;
            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }

        // Wait for all threads to finish and calculate the total sum
        int totalSum = 0;
        try{
            for (SumThread thread : threads){
                thread.join();
                totalSum += thread.getPartialSum();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // Print the total sum
        System.out.println("Total Sum: " + totalSum);
    }
}
