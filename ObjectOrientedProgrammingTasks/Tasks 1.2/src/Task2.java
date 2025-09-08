import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the lenght of the first leg of the triangle:");
        double leg1 = Double.parseDouble(scanner.nextLine());
        System.out.println("Give the lenght of the second leg of the triangle:");
        double leg2 = Double.parseDouble(scanner.nextLine());

        System.out.print("The length of the hypotenuse is:" + Math.sqrt(leg1*leg1 + leg2*leg2));
        scanner.close();
    }
}