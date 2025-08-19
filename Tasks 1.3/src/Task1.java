import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("""
                ██████████████████████████████████████████████████████████
                
                █   ██  █  █  ██  ███  ███   ██   █ █   ██  ████ ██  ██  █
                   █    █  █ █  █ █  █ █  █ █  █ █ █ █ █  █  ██  ██ █
                █  █ ██ █  █ ████ █  █ ███  █  █ █   █ ████  ██  ██ █    █
                    ██   ██  █  █ ███  █  █  ██  █   █ █  █  ██  ██  ██
                █                                                        █
                ██████████████████████████████████████████████████████████
                █ax^2 + bx + c = 0                                       █
                """);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Give coefficient a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("█  "+ a + "x^2 + bx + c = 0                                    █");
        System.out.print("Give coefficient b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("█"+a + "x^2 + " + b + "x + c = 0                                     █");
        System.out.print("Give coefficient c: ");
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println("█" + a + "x^2 + " + b + "x + " + c + " = 0                                    █");

        int discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double sqrt = Math.sqrt(discriminant);
            double root1 = (-b + sqrt) / (2.0 * a);
            double root2 = (-b - sqrt) / (2.0 * a);
            System.out.println("Two real roots: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2.0 * a);
            System.out.println("One real root: " + root);
        } else {
            double realPart = -b / (2.0 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2.0 * a);
            System.out.printf("Zero real roots: %.2f + %.2fi and %.2f - %.2fi\n",
                    realPart, imaginaryPart, realPart, imaginaryPart);
        }
        System.out.print("██████████████████████████████████████████████████████████");
        scanner.close();
    }
}