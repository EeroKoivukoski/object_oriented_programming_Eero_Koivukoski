import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many integers do you want to enter?");
        int num = input.nextInt();

        //create arrays
        int[] numb = new int[num];
        int[] numb2 = new int[num];

        //fill the first array
        for (int i = 1; i <= num; i++) {
            System.out.print("Please enter number " + i + ": ");
            numb[i - 1] = input.nextInt();
        }

        //this tracks how many numbers are in the numb2 array
        int amountofnumbers = 1;

        //this boolean is used to check if there were any duplicates
        boolean check = true;

        //we put the first one in beforehand cause i don't know how to run a for loop with zero loops
        numb2[0] = numb[0];
        int currentnumber;
        //First for loop is used to go through the numbers in the first array
        for (int i = 2; i <= num; i++) {
            currentnumber = numb[i - 1];

            //second loop is used to check if the number already exists in the numb2 array
            for (int j = 1; j <= amountofnumbers; j++) {
                if (currentnumber == numb2[j - 1]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                numb2[amountofnumbers] = currentnumber;
                amountofnumbers++;
            } else {
                check = true;
            }
        }
        for (int i = 1; i <= amountofnumbers; i++) {
            System.out.print(numb2[i - 1]);
        }
    }
}
