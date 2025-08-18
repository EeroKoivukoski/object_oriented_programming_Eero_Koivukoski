import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the temperature in farenheit:");
        float Farenheit = Float.parseFloat(scanner.nextLine());


        System.out.println("\n");
        System.out.printf("The temperature in celsius:   %.1f \n", (Farenheit-32)/1.8);
        scanner.close();
    }
}
