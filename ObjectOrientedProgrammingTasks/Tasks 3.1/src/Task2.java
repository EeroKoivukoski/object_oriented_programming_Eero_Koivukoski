class Bus extends Car{
    private int passangers;
    private final int seats;
    Bus(String typeName, double gasolineCapacity,int seats) {
        super(typeName, gasolineCapacity);
        this.passangers = 0;
        this.seats = seats;
    }
    void passangerEnter(){
        if(passangers < seats) {
            passangers++;
            System.out.println("Passanger Entered");
        }
        else {
            System.out.println("Seats full");
        }
    }
    void passangerExit(){
        if(passangers > 0){
            passangers--;
            System.out.println("Passanger Exited");
        }
    }
}
class CarDriver2 {
    public static void main(String[] args) {
        Bus myCar = new Bus("bus", 400,8);
        myCar.fillTank();
        myCar.cruiseControl(50);
        myCar.accelerate();
        myCar.passangerEnter();
        myCar.passangerExit();
        for (int i=0;i<9;i++){
            myCar.passangerEnter();
        }

        while (myCar.getSpeed() > 0) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
