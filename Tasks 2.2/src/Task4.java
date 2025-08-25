import java.util.ArrayList;

//Class to create grocer objects
class Grocer4 {
    public String itemName;
    public double itemPrice;
    public String itemCategory;
    public int itemQuantity;
    public Grocer4(String itemName, double itemPrice, String itemCategory, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
    }
}

//The Grocery list manager
class GroceryListManager4 {
    public final ArrayList<Grocer4> groceryList = new ArrayList<>();

    void addItem(String item,Double cost,String category,int quantity) {
        System.out.println("Adding " + item + " to the list...");
        boolean check = false;
        for (Grocer4 grocer : groceryList) {
            if (grocer.itemName.equals(item)) {
                check = true;
                break;
            }
        }
        if (!check) {
            groceryList.add(new Grocer4(item, cost, category, quantity));
        }
        else {
            System.out.println("Item " + item + " already exists");
        }
    }

    void removeItem(String item) {
        boolean found = false;
        Grocer4 foundGrocer = null;
        System.out.println("Removing " + item + " from the list...");
        for(Grocer4 grocer : groceryList){
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
        for(Grocer4 item : groceryList){
            System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory + ", quantity:"+ item.itemQuantity);
        }
    }

    void displayListByCategory(String category){
        int itemCount = 1;
        System.out.println(category+" List:");
        for(Grocer4 item : groceryList){
            if(item.itemCategory.equals(category)){
                System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory+ ", quantity:"+ item.itemQuantity);
            }
        }
    }

    void checkItem(String item){
        boolean found = false;
        for(Grocer4 grocer : groceryList){
            if(grocer.itemName.equals(item)){
                System.out.println(item + " is in the list!");
                found = true;
            }
        }
        if (!found){
            System.out.println(item + " is not in the list!");
        }
    }

    void updateQuantity(String item,int quantity){
        boolean found = false;
        Grocer4 foundGrocer = null;
        for(Grocer4 grocer : groceryList){
            if(grocer.itemName.equals(item)){
                System.out.println(item + " is in the list!");
                found = true;
                foundGrocer = grocer;
            }
        }
        if (!found){
            System.out.println(item + " is not in the list!");}
        else{
            groceryList.remove(foundGrocer);
            groceryList.add(new Grocer4(item, foundGrocer.itemPrice, foundGrocer.itemCategory, quantity));
        }
    }
    String totalPrice(){
        double totalPrice = 0;
        for(Grocer4 grocer : groceryList){
            totalPrice += grocer.itemPrice;
        }
        return "Items in the list total to: " + totalPrice +"€!";
    }
    void displayAvailableItems(){
        int itemCount = 1;
        System.out.println("Available Items:");
        for(Grocer4 item : groceryList){
            if(item.itemQuantity > 0){
                System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory + ", quantity:"+ item.itemQuantity);
            }
        }
    }
}

//Class to test the grocery list manager
class GroceryListTester4  {
    public static void main(String[] args) {
        GroceryListManager4 myGroceryListManager4 = new GroceryListManager4();
        myGroceryListManager4.addItem("Tomato ketchup",3.52,"Condiments",1);
        myGroceryListManager4.addItem("Pepsi cola", 6.99,"Drinks",0);
        myGroceryListManager4.addItem("Halloumi cheese",123.72,"Dairy",4);
        myGroceryListManager4.addItem("Chicken nugget",1.0,"Food",2);
        myGroceryListManager4.addItem("Milk",2.50,"Dairy",4);
        myGroceryListManager4.addItem("Hamburger",7.20,"Food",1);
        myGroceryListManager4.addItem("Chicken nugget",1.0,"Food",1);
        myGroceryListManager4.updateQuantity("Tomato ketchup",3);
        myGroceryListManager4.displayList();
        myGroceryListManager4.displayListByCategory("Food");
        myGroceryListManager4.removeItem("Tomato ketchup");
        myGroceryListManager4.removeItem("Pepsi cola");
        myGroceryListManager4.removeItem("Parmesan cheese");
        myGroceryListManager4.displayList();
        myGroceryListManager4.checkItem("Chicken nugget");
        myGroceryListManager4.checkItem("Tomato ketchup");
        myGroceryListManager4.displayAvailableItems();
        System.out.println(myGroceryListManager4.totalPrice());
    }
}