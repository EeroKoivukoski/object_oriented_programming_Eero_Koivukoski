//interface
interface Vehicle {
    void start();
    void stop();
    void getInfo();
}

//Car class
class Car implements Vehicle {
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
        System.out.println("Fuel: "+ this.fuelType);
        System.out.println("Color: "+this.color);
        System.out.println();
    }
    private final String color;
    private final String fuelType;

    Car(String fuelType,String color){
        this.fuelType=fuelType;
        this.color = color;
    }

    String getFuelType() { return fuelType; }
    String getColor() { return color; }
}

//Bus subclass
class Bus extends Car implements Vehicle {
    @Override
    public void getInfo() {
        System.out.println("Bus information:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Fuel: "+ this.getFuelType());
        System.out.println("Capacity: "+this.seats);
        System.out.println();
    }

    private final int seats;
    Bus(String fuelType,String color,int seats) {
        super(fuelType,color);
        this.seats = seats;
    }
}

//Motorcycle subclass
class Motorcycle extends Car {
    Motorcycle(String fuelType, String color) {
        super(fuelType,color);
    }
}

//Test class to test the work
class VehicleDemo {
    public static void main(String[] args) {
        Vehicle Car = new Car("Petrol", "Red");
        Vehicle Motorcycle = new Motorcycle("Gasoline", "Black");
        Vehicle Bus = new Bus("Diesel","Blue",40);
        Car.start();
        Car.stop();
        Car.getInfo();
        Motorcycle.start();
        Motorcycle.stop();
        Motorcycle.getInfo();
        Bus.start();
        Bus.stop();
        Bus.getInfo();
    }
}