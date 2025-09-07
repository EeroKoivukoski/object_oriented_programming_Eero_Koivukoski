import java.util.LinkedList;

public class ServicePoint {
    private final LinkedList<Customer> queue;
    private static long totalPreviousWaitingTime = 0;
    private static long totalPreviousServiceTime = 0;
    private static long totalPreviousResponseTime = 0;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    public long getTotalServiceTime() {
        return totalPreviousServiceTime;
    }
    public long getTotalResponseTime() {
        return totalPreviousResponseTime;
    }
    public long getTotalWaitingTime() {
        return totalPreviousWaitingTime;
    }
    private static void setTotalPreviousWaitingTime(long totalPreviousWaitingTime) { ServicePoint.totalPreviousWaitingTime += totalPreviousWaitingTime; }
    private static void setTotalPreviousServiceTime(long totalPreviousServiceTime) { ServicePoint.totalPreviousServiceTime += totalPreviousServiceTime; }
    private static void setTotalPreviousResponseTime(long totalPreviousResponseTime) { ServicePoint.totalPreviousResponseTime += totalPreviousResponseTime; }

    public void addToQueue(Customer customer) {
        queue.addFirst(customer); // add to front
    }

    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeLast();
        }
        return null;
    }

    public void serve(int loop) {
        long totalWaitingTime = 0;
        long totalServiceTime = 0;
        long totalResponseTime = 0;
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                customer.setServiceStartTime();
                int sleepTime = (int) (500 + Math.random() * 1000);
                try {
                    Thread.sleep(sleepTime);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                customer.setServiceEndTime();

                //Save metrics to variables
                totalWaitingTime += customer.getTimeSpentInQueue();
                totalServiceTime += customer.getTimeSpentInService();
                totalResponseTime += customer.getTimeToRespond();
            }
        }
        System.out.println("Loop number: " + loop);
        System.out.println("Loop " + loop + " waiting time: " + totalWaitingTime + " ms| Average: " + totalWaitingTime/5 + "ms");
        System.out.println("Loop " + loop + " service time: " + totalServiceTime + " ms| Average: " + totalServiceTime/5 + "ms");
        System.out.println("Loop " + loop + " response time: " + totalResponseTime + " ms| Average: " + totalResponseTime/5 + "ms");
        System.out.println("-----------------------------------------------");
        setTotalPreviousWaitingTime(totalWaitingTime);
        setTotalPreviousServiceTime(totalServiceTime);
        setTotalPreviousResponseTime(totalResponseTime);
    }
}