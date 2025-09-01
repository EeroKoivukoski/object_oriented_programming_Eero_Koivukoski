import java.util.Scanner;

public class TestMainTask6 {
    public static void main(String[] args) {
        boolean run = true;
        int loops = 0;

        while(run) {
            boolean check;
            do {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.print("How many loops of simulation? : ");
                    loops = input.nextInt();
                    check = true;
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    check = false;
                }
            }while(!check);
            if (loops > 0) {
                run = false;
            } else {
                System.out.println("Invalid input!");
            }
        }
        System.out.println("-----------------------------------------------");
        ServicePoint2 servicePoint = new ServicePoint2();
        CustomerGenerator2 generator = new CustomerGenerator2();
        for (int loop = 1; loop < loops+1; loop++) {
            generator.generateCustomers(5, servicePoint);
            servicePoint.serve(loop);
        }
        System.out.println("Total:");
        System.out.println("Total waiting time: " + servicePoint.getTotalWaitingTime() + "ms| Average: " + servicePoint.getTotalWaitingTime()/(5L *loops) + "ms" );
        System.out.println("Total service time: " + servicePoint.getTotalServiceTime() + "ms| Average: " + servicePoint.getTotalServiceTime()/(5L *loops) + "ms");
        System.out.println("Total response time: " + servicePoint.getTotalResponseTime() + "ms| Average: " + servicePoint.getTotalResponseTime()/(5L *loops) + "ms");
        System.out.println("--------------------------------------------");
    }
}