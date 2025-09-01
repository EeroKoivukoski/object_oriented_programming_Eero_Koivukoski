public class TestMainTask5 {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator();
        generator.generateCustomers(5, servicePoint);
        servicePoint.serve();
    }
}
