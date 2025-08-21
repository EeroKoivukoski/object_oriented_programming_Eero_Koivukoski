class CoffeeMaker {
    //variables for mimicing a coffee machine
    boolean power = false; String coffeeType = "normal"; int coffeeAmount = 0;

    //method to check power of th coffee maker
    public String isOn(){
        if(power){
            return "on";
        }
        else{
            return "off";
        }
    }

    //method to check what mode it's in
    public String whatCoffeeType(){ return coffeeType; }

    //method to check the coffee amount
    public int whatAmount(){ return coffeeAmount; }

    //method to switch the power
    public void onOff(){ power=!power; }

    //method to switch the mode
    public void switchMode(){
        if (power){
            if (coffeeType.equals("normal")){
                coffeeType="espresso";
            }
            else {
                coffeeType="normal";
            }
        }
    }

    public void switchAmount(int amount){
        if (power) {
            coffeeAmount = coffeeAmount + amount;
            if (coffeeAmount > 80) {
                coffeeAmount = 80;
            } else if (coffeeAmount < 10) {
                coffeeAmount = 10;
            }
        }
    }
}

class CoffeeMakerDriver {
    public static void main(String[] args) {
        //Create object
        CoffeeMaker mycoffeeMaker=new CoffeeMaker();

        //Call the onOff method to turn the coffee maker on
        mycoffeeMaker.onOff();
        System.out.println("Coffee maker is "+mycoffeeMaker.isOn()+".");

        //Call the switchMode method to switch the coffee mode
        mycoffeeMaker.switchMode();
        System.out.println("Coffee type is "+mycoffeeMaker.whatCoffeeType()+".");

        //Call the switchAmount method to change the coffee amount(it is limited to 10-80ml).
        mycoffeeMaker.switchAmount(50);
        System.out.println("Coffee amount is "+mycoffeeMaker.whatAmount()+"ml.");

        mycoffeeMaker.onOff();
        System.out.println("Coffee maker is "+mycoffeeMaker.isOn()+".");
    }
}