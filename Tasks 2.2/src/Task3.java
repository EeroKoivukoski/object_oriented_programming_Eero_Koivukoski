import java.util.ArrayList;

//Class to create grocer objects
class Grocer3 {
    public String itemName;
    public double itemPrice;
    public String itemCategory;
    public Grocer3(String itemName, double itemPrice, String itemCategory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
    }
}

//The Grocery list manager
class GroceryListManager3 {
    public final ArrayList<Grocer3> groceryList = new ArrayList<>();

    void addItem(String item,Double cost,String category) {
        System.out.println("Adding " + item + " to the list...");
        boolean check = false;
        for (Grocer3 grocer : groceryList) {
            if (grocer.itemName.equals(item)) {
                check = true;
                break;
            }
        }
        if (!check) {
            groceryList.add(new Grocer3(item, cost, category));
        }
        else {
            System.out.println("Item " + item + " already exists");
        }
    }

    void removeItem(String item) {
        boolean found = false;
        Grocer3 foundGrocer = null;
        System.out.println("Removing " + item + " from the list...");
        for(Grocer3 grocer : groceryList){
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
        for(Grocer3 item : groceryList){
            System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory);
        }
    }

    void displayListByCategory(String category){
        int itemCount = 1;
        System.out.println(category+" List:");
        for(Grocer3 item : groceryList){
            if(item.itemCategory.equals(category)){
                System.out.println(itemCount++ + ". " + item.itemName + " " + item.itemPrice + "€, category:"+ item.itemCategory);
            }
        }
    }

    void checkItem(String item){
        boolean found = false;
        for(Grocer3 grocer : groceryList){
            if(grocer.itemName.equals(item)){
                System.out.println(item + " is in the list!");
                found = true;
            }
        }
        if (!found){
            System.out.println(item + " is not in the list!");}
    }

    String totalPrice(){
        double totalPrice = 0;
        for(Grocer3 grocer : groceryList){
            totalPrice += grocer.itemPrice;
        }
        return "Items in the list total to: " + totalPrice +"€!";
    }
}

//Class to test the grocery list manager
class GroceryListTester3  {
    public static void main(String[] args) {
        GroceryListManager3 myGroceryListManager3     = new GroceryListManager3();
        myGroceryListManager3.addItem("Tomato ketchup",3.52,"Condiments");
        myGroceryListManager3.addItem("Pepsi cola", 6.99,"Drinks");
        myGroceryListManager3.addItem("Halloumi cheese",123.72,"Dairy");
        myGroceryListManager3.addItem("Chicken nugget",1.0,"Food");
        myGroceryListManager3.addItem("Milk",2.50,"Dairy");
        myGroceryListManager3.addItem("Hamburger",7.20,"Food");
        myGroceryListManager3.addItem("Chicken nugget",1.0,"Food");
        myGroceryListManager3.displayList();
        myGroceryListManager3.displayListByCategory("Food");
        myGroceryListManager3.removeItem("Tomato ketchup");
        myGroceryListManager3.removeItem("Pepsi cola");
        myGroceryListManager3.removeItem("Parmesan cheese");
        myGroceryListManager3.displayList();
        myGroceryListManager3.checkItem("Chicken nugget");
        myGroceryListManager3.checkItem("Tomato ketchup");
        System.out.println(myGroceryListManager3.totalPrice());
    }
}