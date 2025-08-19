import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many integers do you want to enter?");
        int num = input.nextInt();
        int[] numbers = new int[num];
        for (int i = 1; i <= num; i++) {
            System.out.print("Please enter number " + i + ": ");
            numbers[i-1] = input.nextInt();
        }
        int hsum=0,end=0,start = 0,sum;
        boolean initial = true;
        for (int j = 1; j <= num; j++) {
            sum = 0;
            for (int i = j; i <= num; i++) {
                sum += numbers[i-1];
                if (sum >= hsum || initial) {
                    initial = false;
                    hsum = sum;
                    start = j;
                    end = i;
                }
            }
        }
        System.out.println("Largest sum possible is: "+ hsum + "\nIntegers: "+ start+"-"+end+".");
    }
}
