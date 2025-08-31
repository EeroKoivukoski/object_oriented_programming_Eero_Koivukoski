public class CustomerGenerator {
    public void generateCustomers(int amountOfCustomersWanted, ServicePoint servicepoint) {
        for (int loop = 0; loop < amountOfCustomersWanted; loop++) {
            Customer customer = new Customer();
            servicepoint.addToQueue(customer);
        }
    }
}