public class TestMainTask5 {
    public static void main(String[] args) {
        ServicePoint servicePointp = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator();
        generator.generateCustomers(5, servicePointp);
        servicePointp.serve();
    }
}