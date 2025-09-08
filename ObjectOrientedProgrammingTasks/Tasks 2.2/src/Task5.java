import java.util.ArrayList;

//Class to create grocer objects
class Grocer5 {
    public String itemName;
    public double itemPrice;
    public String itemCategory;
    public int itemQuantity;
    public Grocer5(String itemName, double itemPrice, String itemCategory, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.itemQuantity = itemQuantity;
    }
}

//The Grocery list manager
class GroceryListManager5 {
    public final ArrayList<Grocer5> groceryList = new ArrayList<>();

    void addItem(String item,Double cost,String category,int quantity) {
        System.out.println("Adding " + item + " to the list...");
        boolean check = false;
        for (Grocer5 grocer : groceryList) {
            if (grocer.itemName.equals(item)) {
                check = true;
                break;
            }
        }
        if (!check) {
            groceryList.add(new Grocer5(item, cost, category, quantity));
        }
        else {
            System.out.println("Item " + item + " already exists");
        }
    }

    void removeItem(String item) {
        boolean found = false;
        Grocer5 foundGrocer = null;
        System.out.println("Removing " + item + " from the list...");
        for(Grocer5 grocer : groceryList){
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
        for(Grocer5 item : groceryList){
            System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory + ", quantity:"+ item.itemQuantity);
        }
    }

    void displayListByCategory(String category){
        int itemCount = 1;
        System.out.println(category+" List:");
        for(Grocer5 item : groceryList){
            if(item.itemCategory.equals(category)){
                System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory+ ", quantity:"+ item.itemQuantity);
            }
        }
    }

    void checkItem(String item){
        boolean found = false;
        for(Grocer5 grocer : groceryList){
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
        Grocer5 foundGrocer = null;
        for(Grocer5 grocer : groceryList){
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
            groceryList.add(new Grocer5(item, foundGrocer.itemPrice, foundGrocer.itemCategory, quantity));
        }
    }
    String totalPrice(){
        double totalPrice = 0;
        for(Grocer5 grocer : groceryList){
            totalPrice += grocer.itemPrice;
        }
        return "Items in the list total to: " + totalPrice +"€!";
    }
    void displayAvailableItems(){
        int itemCount = 1;
        System.out.println("Available Items:");
        for(Grocer5 item : groceryList){
            if(item.itemQuantity > 0){
                System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory + ", quantity:"+ item.itemQuantity);
            }
        }
    }
}

//Class to test the grocery list manager
class GroceryListTester5  {
    public static void main(String[] args) {
        GroceryListManager5 myGroceryListManager5 = new GroceryListManager5();
        myGroceryListManager5.addItem("Tomato ketchup",3.52,"Condiments",1);
        myGroceryListManager5.addItem("Pepsi cola", 6.99,"Drinks",0);
        myGroceryListManager5.addItem("Halloumi cheese",123.72,"Dairy",4);
        myGroceryListManager5.addItem("Chicken nugget",1.0,"Food",2);
        myGroceryListManager5.addItem("Milk",2.50,"Dairy",4);
        myGroceryListManager5.addItem("Hamburger",7.20,"Food",1);
        myGroceryListManager5.addItem("Chicken nugget",1.0,"Food",1);
        myGroceryListManager5.updateQuantity("Tomato ketchup",3);
        myGroceryListManager5.displayList();
        myGroceryListManager5.displayListByCategory("Food");
        myGroceryListManager5.removeItem("Tomato ketchup");
        myGroceryListManager5.removeItem("Pepsi cola");
        myGroceryListManager5.removeItem("Parmesan cheese");
        myGroceryListManager5.displayList();
        myGroceryListManager5.checkItem("Chicken nugget");
        myGroceryListManager5.checkItem("Tomato ketchup");
        myGroceryListManager5.displayAvailableItems();
        System.out.println(myGroceryListManager5.totalPrice());
    }
}