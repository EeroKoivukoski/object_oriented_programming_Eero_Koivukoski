interface Vehicle4 {
    void start();
    void stop();
    void getInfo();
    void calculateFuelEfficiency();
}

interface ElectricVehicle4 {
    void start();
    void stop();
    void getInfo();
    void charge();
    void calculateFuelEfficiency();
}

abstract class AbstractVehicle4 implements Vehicle4, ElectricVehicle4 {
    String name;
    boolean isCharged;
    AbstractVehicle4(String name){
        this.name=name;
    }
    String getName(){ return name; }
    @Override
    public void charge() {
        if (this.getClass().getSimpleName().equals("ElectricCar4")) {
            if (!isCharged) {
                System.out.println("Charging...");
                this.isCharged = true;
            } else {
                System.out.println("Already charged!");
            }
        }
    }
    @Override
    public void calculateFuelEfficiency() {
        switch (this.getClass().getSimpleName()) {
            case "ElectricCar4":
                System.out.println("Fuel efficiency is 0.20 kWh per km");
                System.out.println();
                break;
            case "ElectricMotrcycle4":
                System.out.println("Fuel efficiency is 0.17 kWh per km");
                System.out.println();
                break;
            case "Car4":
                System.out.println("Fuel efficiency is 7 liters per km");
                System.out.println();
                break;
            case "Motorcycle4":
                System.out.println("Fuel efficiency is 5 liters per km");
                System.out.println();
                break;
            case "Bus4":
                System.out.println("Fuel efficiency is 25 liters per km");
                System.out.println();
                break;
        }
    }
}

class Car4 extends AbstractVehicle4 implements Vehicle4 {
    @Override
    public void start() {
        System.out.println(this.getClass().getSimpleName()+" is starting...");
    }
    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName()+" is stopping...");
    }
    @Override
    public void getInfo() {
        System.out.println(this.getClass().getSimpleName()+" information:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Name: " + this.getName());
        System.out.println("Fuel: "+ this.fuelType);
        System.out.println("Color: "+this.color);
    }
    private final String color;
    private final String fuelType;

    Car4(String name, String fuelType, String color) {
        super(name);
        this.fuelType=fuelType;
        this.color = color;
    }

    String getFuelType() { return fuelType; }
    String getColor() { return color; }
}

class Bus4 extends Car4 implements Vehicle4 {
    @Override
    public void getInfo() {
        System.out.println("Bus information:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Name: " + this.getName());
        System.out.println("Fuel: "+ this.getFuelType());
        System.out.println("Capacity: "+this.seats);
    }

    private final int seats;
    Bus4(String name, String fuelType, String color, int seats) {
        super(name, fuelType,color);
        this.seats = seats;
    }
}

class Motorcycle4 extends Car4 {
    Motorcycle4(String name, String fuelType, String color) {
        super(name,fuelType,color);
    }
}

class ElectricCar4 extends AbstractVehicle4 implements ElectricVehicle4 {
    Boolean isCharged;
    @Override
    public void start() {
        System.out.println(this.getClass().getSimpleName()+" is starting...");
    }
    @Override
    public void stop() {
        System.out.println(this.getClass().getSimpleName()+" is stopping...");
    }
    @Override
    public void getInfo() {
        System.out.println(this.getClass().getSimpleName()+" information:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Name: " + this.getName());
        System.out.println("Fuel: "+ this.fuelType);
        System.out.println("Color: "+this.color);
    }
    private final String color;
    private final String fuelType;

    ElectricCar4(String name, String color) {
        super(name);
        this.fuelType="Electricity";
        this.color = color;
        this.isCharged = false;
    }

    String getFuelType() { return fuelType; }
    String getColor() { return color; }
}

class ElectricMotorcycle4 extends ElectricCar4 implements ElectricVehicle4 {

    ElectricMotorcycle4(String name, String color) {
        super(name, color);
    }
}

class VehicleDemo4{
    public static void main(String[] args) {
        ElectricVehicle4 eCar = new ElectricCar4("Toyota","Red");
        ElectricMotorcycle4 eMotorcycle = new ElectricMotorcycle4("Ducati","Black");

        eCar.charge();
        eCar.charge();
        eCar.start();
        eCar.stop();
        eCar.getInfo();
        eCar.calculateFuelEfficiency();

        eMotorcycle.charge();
        eMotorcycle.charge();
        eMotorcycle.start();
        eMotorcycle.stop();
        eMotorcycle.getInfo();
        eMotorcycle.calculateFuelEfficiency();

        Vehicle4 Car = new Car4("Toyota","Petrol", "Red");
        Vehicle4 Motorcycle = new Motorcycle4("Ducati","Gasoline", "Black");
        Vehicle4 Bus = new Bus4("Volvo","Diesel","Blue",40);

        Car.start();
        Car.stop();
        Car.getInfo();
        Car.calculateFuelEfficiency();

        Motorcycle.start();
        Motorcycle.stop();
        Motorcycle.getInfo();
        Motorcycle.calculateFuelEfficiency();

        Bus.start();
        Bus.stop();
        Bus.getInfo();
        Bus.calculateFuelEfficiency();
    }
}
