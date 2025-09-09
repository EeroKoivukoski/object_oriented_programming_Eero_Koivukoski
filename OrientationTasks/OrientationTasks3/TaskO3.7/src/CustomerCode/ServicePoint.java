package CustomerCode;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private final Queue<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer c) {
        queue.add(c);
    }

    public boolean hasCustomers() {
        return !queue.isEmpty();
    }

    public Customer serveNext() {
        return queue.poll();
    }
}
