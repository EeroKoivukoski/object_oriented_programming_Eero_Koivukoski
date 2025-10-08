import java.util.ArrayList;
import java.util.List;

public class Task2Demo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        System.out.println("Original List");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        numbers.removeIf(n -> n % 2 == 0);

        System.out.println("\nAfter Filtering Even Numbers");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        numbers.replaceAll(n -> n * 2);

        System.out.println("\nAfter Doubling Odd Numbers");
        numbers.forEach(n -> System.out.print(n + " "));
        System.out.println();

        final int[] sum = {0};
        numbers.forEach(n -> sum[0] += n);

        System.out.println("\nSum of Numbers");
        System.out.println(sum[0]);
    }
}
