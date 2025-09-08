import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = 0;
        System.out.print("Give a binary number: ");
        String bin = (scanner.nextLine());
        for(int a = 0; a < bin.length(); a++){
            if(bin.charAt(a) == '1') {
                x+=(int)Math.pow(2,bin.length()-a-1);
            }
            else if (bin.charAt(a) != '0') {
                System.out.print("Not a binary number!");
                System.exit(0);
            }
        }
        System.out.println("The binary number is " + x);
    }
}
