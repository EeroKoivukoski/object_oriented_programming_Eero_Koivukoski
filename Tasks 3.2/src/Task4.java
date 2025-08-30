abstract class  AbstractVehicle implements Vehicle, ElectricVehicle{
    String name;
    boolean isCharged;
    AbstractVehicle(String name){
        this.name=name;
    }
    String getName(){ return name; }
    @Override
    public void charge() {
        if (this.getClass().getSimpleName().equals("ElectricVehicle")) {
            if (!isCharged) {
                System.out.println("Charging...");
                this.isCharged = true;
            } else {
                System.out.println("Already charged!");
            }
        }
    }


}
class Car2 extends AbstractVehicle implements Vehicle {
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
        System.out.println();
    }
    private final String color;
    private final String fuelType;

    Car2(String name, String fuelType,String color) {
        super(name);
        this.fuelType=fuelType;
        this.color = color;
    }

    String getFuelType() { return fuelType; }
    String getColor() { return color; }
}

//Bus subclass
class Bus2 extends Car2 implements Vehicle {
    @Override
    public void getInfo() {
        System.out.println("Bus information:");
        System.out.println("Type: " + this.getClass().getSimpleName());
        System.out.println("Name: " + this.getName());
        System.out.println("Fuel: "+ this.getFuelType());
        System.out.println("Capacity: "+this.seats);
        System.out.println();
    }

    private final int seats;
    Bus2(String name, String fuelType,String color,int seats) {
        super(name, fuelType,color);
        this.seats = seats;
    }
}

//Motorcycle subclass
class Motorcycle2 extends Car2{
    Motorcycle2(String name,String fuelType, String color) {
        super(name,fuelType,color);
    }
}
//I know that this isn't exactly what was asked in the assingment but since bus and motorcycle are subclasses of car and car is a subclass of abstract, it feels pointless to make them subclasses of abstract vehicle.

class VehicleDemo2 {
    public static void main(String[] args) {
        Vehicle Car = new Car2("Toyota","Petrol", "Red");
        Vehicle Motorcycle = new Motorcycle2("Ducati","Gasoline", "Black");
        Vehicle Bus = new Bus2("Volvo","Diesel","Blue",40);

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
interface ElectricVehicle {
    void start();
    void stop();
    void getInfo();
    void charge();
}
class  ElectricCar extends AbstractVehicle implements ElectricVehicle {
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
        System.out.println();
    }
    @Override
    public void charge() {
        if (!isCharged) {
            System.out.println("Charging...");
            this.isCharged = true;
        }
        else  {
            System.out.println("Already charged!");
        }
    }
    private final String color;
    private final String fuelType;

    ElectricCar(String name,String color) {
        super(name);
        this.fuelType="Electricity";
        this.color = color;
        this.isCharged = false;
    }

    String getFuelType() { return fuelType; }
    String getColor() { return color; }
}


class ElectricMotorcycle extends ElectricCar implements ElectricVehicle {

    ElectricMotorcycle(String name, String color) {
        super(name, color);
    }
}

class VehicleDemo3 {
    public static void main(String[] args) {
        ElectricVehicle Car = new ElectricCar("Toyota","Red");
        ElectricMotorcycle Motorcycle = new ElectricMotorcycle("Ducati","Black");

        Car.charge();
        Car.charge();
        Car.start();
        Car.stop();
        Car.getInfo();

        Motorcycle.charge();
        Motorcycle.charge();
        Motorcycle.start();
        Motorcycle.stop();
        Motorcycle.getInfo();

    }
}
