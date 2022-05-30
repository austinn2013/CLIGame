package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private double gold;
    private static final int SPACE = 10;
    private ArrayList<String> items = new ArrayList<String>();

    public Inventory(double gold, ArrayList<String> items) {
        this.gold = gold;
        this.items.addAll(items);
    }

    public void showInventory() {
        System.out.println("Gold: " + this.gold);
        int itemNumber = 1;
        for (String items : this.items) {
            System.out.println(itemNumber + ". " + items);
        }
    }

    public boolean checkSpace(ArrayList<String> newItems) {
        if (newItems.size() + this.items.size() >= SPACE) {
            int difference = this.items.size() - newItems.size();
            System.out.println("Not enough space to fit all items! The last " + difference + " items will not be" +
                    "added to backpack!");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();
            System.out.print("Do you want to discard " + difference + " items in your inventory to make space?");
            if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
                // Add functionality here
                showInventory();
                System.out.print("Which item(s) to remove? ");
                boolean done = false;
                int itemAdded = 0;
                Scanner getItem = new Scanner(System.in);
                while(!done) {
                    if (itemAdded == difference) {
                        done = true;
                    }
                    int remainingItems = difference - itemAdded;
                    System.out.print("You can add " + remainingItems + " more item(s)");
                    int itemNumber = getItem.nextInt();
                    if (itemNumber <= 0 || itemNumber > SPACE) {
                        System.out.println("Incorrect item number! Please re-enter.");
                        continue;
                    }
                    this.items.remove(itemNumber-1);
                    itemAdded++;
                }
                return true;
            }
            else {
                System.out.println("No changes were made to your inventory.");
                return false;
            }
        }
        return true;
    }

    public double getGold() {
        return this.gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

}
