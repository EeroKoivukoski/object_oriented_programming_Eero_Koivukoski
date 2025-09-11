public class Task1 {
    static class NumberPrinter {
        private final int range;
        private int current = 1;
        private final Object lock = new Object();
        private final String stro = " |%6d|\n";
        private final String stre = "|%6d|\n";

        public NumberPrinter(int range) {
            this.range = range;
        }

        public void printOdd() {
            while (current <= range) {
                synchronized (lock) {
                    if (current % 2 != 0) {
                        System.out.printf("|Odd Thread: " +stro, current);
                        current++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }

        public void printEven() {
            while (current <= range) {
                synchronized (lock) {
                    if (current % 2 == 0) {
                        System.out.printf("|Even Thread: " + stre, current);
                        current++;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int range = 20; // Specify the range of numbers to be printed
        System.out.println("|-------------|------|\n|Thread Type  |Number|\n|-------------|------|");
        NumberPrinter numberPrinter = new NumberPrinter(range);

        Thread oddThread = new Thread(numberPrinter::printOdd);
        Thread evenThread = new Thread(numberPrinter::printEven);

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("|-------------|------|");

        System.out.println("Printing complete.");
    }
}
