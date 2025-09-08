import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start;
        int end;
        do {
            System.out.print("Give a start number: ");
            start = Integer.parseInt(scanner.nextLine());
            System.out.print("Give a end number: ");
            end = Integer.parseInt(scanner.nextLine());
        } while (start > end);
        System.out.print("Prime numbers between " + start + " and " + end + " are: ");
        for (int i = start; i <= end; i++) {
            boolean prime = true;
            for (int z = 2; z <=  i+1; z++){
                if (i % z == 0 && i != z || i==1) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                System.out.print(i+" ");
            }
        }

    }
}
