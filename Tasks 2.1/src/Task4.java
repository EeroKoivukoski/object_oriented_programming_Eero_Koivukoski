class Car2 {
    private double speed;
    private double gasolineLevel;
    private double speedGoal;
    private String typeName;

    public Car2(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
    }

    public Car2(double gasolineCapacity,double speed) {
        this.speed = speed;
    }

    public void accelerate(int speedchange) {
        if (gasolineLevel > 0 && speed < speedGoal) {
            speed += speedchange;
            gasolineLevel -= 10;
        }
        else{
            speed -= 10;
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

    double getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() { return gasolineLevel; }

    void cruiseControl(int wantedSpeed) { speedGoal = wantedSpeed; }
}
class CarDriver2 {
    public static void main(String[] args) {
        Car2 myCar;

        myCar = new Car2("Toyota Corolla");
        myCar.fillTank();
        myCar.cruiseControl(100);

        for (int i = 0; i < 6; i++) {
            myCar.accelerate(10);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.accelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}