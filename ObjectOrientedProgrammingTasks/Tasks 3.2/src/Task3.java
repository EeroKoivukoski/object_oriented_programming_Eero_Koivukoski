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
