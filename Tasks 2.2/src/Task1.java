import java.util.ArrayList;

class GroceryListManager {
    private final ArrayList<String> groceryList = new ArrayList<>();

    void addItem(String item){ groceryList.add(item); }

    void removeItem(String item){ groceryList.remove(item); }

    void displayList(){
        for(String item : groceryList){
            System.out.println(item);
        }
    }
    void checkItem(String item){
        if(groceryList.contains(item)){
            System.out.println("Item is in the list!");
        }
        else{
            System.out.println("Item is not in the list.");
        }
    }
}

class GroceryListTester  {
    public static void main(String[] args) {
        GroceryListManager myGroceryListManager      = new GroceryListManager();
        myGroceryListManager.addItem("Tomato");
        myGroceryListManager.addItem("Pepsi");
        myGroceryListManager.addItem("Cheese");
        myGroceryListManager.addItem("Chicken");
        myGroceryListManager.displayList();
        myGroceryListManager.removeItem("Tomato");
        myGroceryListManager.removeItem("Pepsi");
        myGroceryListManager.displayList();
        myGroceryListManager.checkItem("Chicken");
        myGroceryListManager.checkItem("Tomato");
    }
}