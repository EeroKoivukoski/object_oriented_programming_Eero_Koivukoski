import java.util.LinkedList;

public class ServicePoint {
    private final LinkedList<Customer> queue;

    public ServicePoint() {
        queue = new LinkedList<>();
    }

    // Add a customer to the queue
    public void addToQueue(Customer customer) {
        queue.addFirst(customer); // add to front
    }

    // Remove a customer from the queue (FIFO)
    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeLast(); // remove from back
        }
        return null;
    }

    // Serve all customers in the queue
    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                try {
                    // Service starts
                    customer.setServiceStartTime();

                    // Simulate service with random time (0.5s - 1.5s)
                    int sleepTime = (int) (500 + Math.random() * 1000);
                    Thread.sleep(sleepTime);

                    // Service ends
                    customer.setServiceEndTime();

                    // Print metrics
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