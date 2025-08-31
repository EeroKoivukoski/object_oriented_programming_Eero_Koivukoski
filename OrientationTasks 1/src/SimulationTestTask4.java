import java.util.LinkedList;
import java.util.Scanner;

public class SimulationTestTask4 {
    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean runCheck = true;

        System.out.println("""
            █████ █   █ ████ █   █ ███  ████ █  █████ █   █ █     █████ █████ █████ █████
            █   █ █   █ █    █   █ █    ██   █  █ █ █ █   █ █     █   █   █   █   █ █   █
            █   █ █   █ ████ █   █ ███  ████ █  █ █ █ █   █ █     █████   █   █   █ █████
            █████ █   █ █    █   █ █       █ █  █ █ █ █   █ █     █   █   █   █   █ █  █
                ██ ███  ████ █████ ███  ████ █  █ █ █ █████ █████ █   █   █   █████ █  ██""");

        while (runCheck) {
            System.out.println("1: Add a customer to the queue");
            System.out.println("2: Remove customer from the queue");
            System.out.println("3: Exit");

            System.out.print("Input: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer newCustomer = new Customer();
                    queue.addFirst(newCustomer);
                    System.out.println("Customer " + newCustomer.getId() + " joined the queue.");
                    break;

                case 2:
                    if (!queue.isEmpty()) {
                        Customer leavingCustomer = queue.removeLast();
                        leavingCustomer.setServiceStartTime();
                        System.out.println("Customer " + leavingCustomer.getId() +
                                " left the queue. Time spent: " +
                                leavingCustomer.getTimeSpentInQueue() + " ns.");
                    }
                    else {
                        System.out.println("The queue is empty.");
                    }
                    break;

                case 3:
                    runCheck = false;
                    System.out.println("Exiting simulation...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
