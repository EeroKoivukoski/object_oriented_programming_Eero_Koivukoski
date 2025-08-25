import java.util.ArrayList;

class GroceryListManager {
    private final ArrayList<String> groceryList = new ArrayList<>();

    void addItem(String item){
        System.out.println("Adding " + item + " to the list...");
        groceryList.add(item);
    }
    void removeItem(String item){
        System.out.println("Removing " + item + " from the list...");
        groceryList.remove(item);
    }

    void displayList(){
        int itemCount = 1;
        System.out.println("Grocery List:");
        for(String item : groceryList){
            System.out.println(itemCount++ + ". " + item);
        }
    }
    void checkItem(String item){
        if(groceryList.contains(item)){
            System.out.println(item + " is in the list!");
        }
        else{
            System.out.println(item + " is not in the list.");
        }
    }
}

class GroceryListTester  {
    public static void main(String[] args) {
        GroceryListManager myGroceryListManager      = new GroceryListManager();
        myGroceryListManager.addItem("Tomato ketchup");
        myGroceryListManager.addItem("Pepsi cola");
        myGroceryListManager.addItem("Halloumi cheese");
        myGroceryListManager.addItem("Chicken nugget");
        myGroceryListManager.displayList();
        myGroceryListManager.removeItem("Tomato ketchup");
        myGroceryListManager.removeItem("Pepsi cola");
        myGroceryListManager.displayList();
        myGroceryListManager.checkItem("Chicken nugget");
        myGroceryListManager.checkItem("Tomato ketchup");
    }
}