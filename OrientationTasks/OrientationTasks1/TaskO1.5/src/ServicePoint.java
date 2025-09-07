import java.util.LinkedList;

public class ServicePoint {
    private final LinkedList<Customer> queue;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    public void addToQueue(Customer customer) {
        queue.addFirst(customer);
    }

    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeLast();
        }
        return null;
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                try {
                    customer.setServiceStartTime();


                    int sleepTime = (int) (500 + Math.random() * 1000);
                    Thread.sleep(sleepTime);
                    customer.setServiceEndTime();
                    System.out.println("Customer " + customer.getId() +
                            " | Waiting time: " + customer.getTimeSpentInQueue() + " ms" +
                            " | Service time: " + customer.getTimeSpentInService() + " ms" +
                            " | Response time: " + customer.getTimeToRespond() + " ms");
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}