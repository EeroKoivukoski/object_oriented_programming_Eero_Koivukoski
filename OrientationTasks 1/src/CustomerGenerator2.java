public class CustomerGenerator2 {
    public void generateCustomers(int amountOfCustomersWanted, ServicePoint2 servicepoint) {
        for (int loop = 0; loop < amountOfCustomersWanted; loop++) {
            Customer customer = new Customer();
            servicepoint.addToQueue(customer);
        }
    }
}