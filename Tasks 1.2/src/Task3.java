import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the amount of grams");
        double grams = Double.parseDouble(scanner.nextLine());
        double leiviska = grams / 13.28 / 32 / 20;
        double naula = leiviska*20%20;
        double luoti = naula*32%32;
        System.out.printf("The grams equal to %.0f",leiviska);
        System.out.printf(" leiviskä, %.0f",naula);
        System.out.printf(" naula and %.2f",luoti);
        System.out.print(" luoti." );
        scanner.close();
    }
}