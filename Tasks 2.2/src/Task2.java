import java.util.ArrayList;

//Class to create grocer objects
class Grocer{
    public String itemName;
    public double itemPrice;
    public Grocer(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
}
//The Grocery list manager
class GroceryListManager2 {
    public final ArrayList<Grocer> groceryList = new ArrayList<>();
    void addItem(String item,Double cost) {
        System.out.println("Adding " + item + " to the list...");
        groceryList.add(new Grocer(item,cost));
    }
    void removeItem(String item) {
        boolean found = false;
        Grocer foundGrocer = null;
        System.out.println("Removing " + item + " from the list...");
        for(Grocer grocer : groceryList){
            if(grocer.itemName.equals(item)){
                foundGrocer = grocer;
                found = true;
            }
        }
        if (found){
            groceryList.remove(foundGrocer);
        }
        else{
            System.out.println(item + " is not in the list!");
        }
        
    }

    void displayList(){
        int itemCount = 1;
        System.out.println("Grocery List:");
        for(Grocer item : groceryList){
            System.out.println(itemCount++ + ". " + item.itemName + ", costing: " + item.itemPrice);
        }
    }
    void checkItem(String item){
        boolean found = false;
        for(Grocer grocer : groceryList){
            if(grocer.itemName.equals(item)){
                System.out.println(item + " is in the list!");
                found = true;
            }
    }
        if (!found){
        System.out.println(item + " is not in the list!");}
    }
    double totalPrice(){
        double totalPrice = 0;
        for(Grocer grocer : groceryList){
            totalPrice += grocer.itemPrice;
        }
        return totalPrice;
    }
}

//Class to test the grocery list manager
class GroceryListTester2  {
    public static void main(String[] args) {
        GroceryListManager2 myGroceryListManager2      = new GroceryListManager2();
        myGroceryListManager2.addItem("Tomato ketchup",3.52);
        myGroceryListManager2.addItem("Pepsi cola", 6.99);
        myGroceryListManager2.addItem("Halloumi cheese",123.72);
        myGroceryListManager2.addItem("Chicken nugget",1.0);
        myGroceryListManager2.displayList();
        myGroceryListManager2.removeItem("Tomato ketchup");
        myGroceryListManager2.removeItem("Pepsi cola");
        myGroceryListManager2.removeItem("Parmesan cheese");
        myGroceryListManager2.displayList();
        myGroceryListManager2.checkItem("Chicken nugget");
        myGroceryListManager2.checkItem("Tomato ketchup");
        System.out.println("Items in the list total to: " + myGroceryListManager2.totalPrice());
    }
}