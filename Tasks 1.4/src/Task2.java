import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Create a array which the user will enter all wanted integers
        System.out.println("How many integers do you want to enter?");
        int num = input.nextInt();
        int[] numbers = new int[num];
        for (int i = 1; i <= num; i++) {
            System.out.print("Please enter number " + i + ": ");
            numbers[i-1] = input.nextInt();
        }

        //Create variable to save the highest sum and the end and start numbers of the max sum
        int hsum=0,sum;
        String start_end = " ";
        boolean initial = true;

        // The first loop goes through each number in the array
        for (int currentstart = 1; currentstart <= num; currentstart++) {

            // create the sum variable to check each group of possible sums
            sum = 0;

            // Second loop adds each nuber in the array one at a time
            for (int currentend = currentstart; currentend <= num; currentend++) {
                sum += numbers[currentend-1];

                // If the current sum is larger or equal than the current max sum, the max sum gets replaced by the current sum.
                // When the max sum gets saved the start and end of the current sum is saved as well.
                if (sum >= hsum || initial) {
                    initial = false;
                    hsum = sum;
                    start_end = " "+currentstart +"-"+ currentend+".";
                }
            }
        }
        System.out.println("Largest sum possible is: "+ hsum + "\nIntegers:"+ start_end+".");
    }
}
