class Car {
    private double speed;
    private double gasolineLevel;
    private final double gasolineCapacity;
    private double speedGoal;
    private final String typeName;
    private final double acceleration;
    private final double gasolineConsumption;

    Car(String typeName, double gasolineCapacity ){
        this.speed = 0;
        this.gasolineLevel = 0;
        this.speedGoal = 0;
        this.typeName = typeName;
        this.gasolineCapacity = gasolineCapacity;
        this.acceleration = 1.5;
        this.gasolineConsumption = 1;

    }


    public void accelerate() {
        if (gasolineLevel > 0 && speed < speedGoal) {
            speed += acceleration;
            gasolineLevel -= gasolineConsumption;
        }
        else{
            if(gasolineLevel > 0){
                speed -= 1;
            }
            else{
                speed = 0;
                System.out.println("Speed is not reachable!");
            }
        }
    }

    public void decelerate(int amount){
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    double getSpeed() { return speed; }

    String getTypeName() { return typeName; }

    void fillTank() {
        gasolineLevel = gasolineCapacity;
    }

    double getGasolineLevel() { return gasolineLevel; }

    void cruiseControl(int wantedSpeed) { speedGoal = wantedSpeed; }
}

class SuperCar extends Car {
    private final double acceleration;
    private final double gasolineConsumption;
    SuperCar(String typeName, double gasolineCapacity) {
        super(typeName, gasolineCapacity);
        this.acceleration = 3;
        this.gasolineConsumption = 6;
    }
}

class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota Corolla",400);
        myCar.fillTank();
        myCar.cruiseControl(400);
        myCar.accelerate();
        while (myCar.getSpeed() > 0) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        SuperCar myCar2 = new SuperCar("Super Toyota Corolla",400);
        myCar2.fillTank();
        myCar2.cruiseControl(400);
        myCar2.accelerate();
        while (myCar2.getSpeed() > 0) {
            myCar2.accelerate();
            System.out.println(myCar2.getTypeName() + ": speed is " + myCar2.getSpeed() + " km/h");
        }
    }
}