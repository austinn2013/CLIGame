package Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Inventory {
    private double gold;
    private static final int SPACE = 10;
    private ArrayList<Item> items;

    public Inventory() {
        this.gold = 100;
        this.items = new ArrayList<Item>();
        for (int i = 0; i < SPACE; i++) {
            this.items.add(new Item(""));
        }
    }

    public void showInventory() {
        System.out.println("\nGold: " + this.gold);
        int itemNumber = 1;
        if (verifyElements(this.items)) {
            System.out.println("Inventory is empty!\n");
        }
        else {
            for (Item item : this.items) {
                System.out.println(itemNumber + ". " + item.getName());
                itemNumber++;
            }
        }
    }

    public Item useItem(Item item) {
        Item usedItem = null;
        Iterator<Item> itemName = this.items.iterator();
        while (itemName.hasNext()) {
            Item tempItem = itemName.next();
            if (tempItem.equals(item)) {
                usedItem = item;
                itemName.remove();
            }
        }
        return usedItem;
    }

    public void addToInventory(Item item) {
        if (hasSpace(this.items)) {
            this.items.add(item);
        }
        else {
            makeSpace(this.items); // function doesn't consider the case where user discards inventory for some items;
            // all or nothing
            this.items.add(item);
        }
    }

    public void makeSpace(ArrayList<Item> newItems) {
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
                System.out.print("You can remove " + remainingItems + " more item(s)");
                int itemNumber = getItem.nextInt();
                if (itemNumber <= 0 || itemNumber > SPACE) {
                    System.out.println("Incorrect item number! Please re-enter.");
                    continue;
                }
                this.items.remove(itemNumber-1);
                itemAdded++;
            }
        }
        else {
            System.out.println("No changes were made to your inventory.");
        }
    }

    public boolean hasSpace(ArrayList<Item> newItems) {
        return newItems.size() + this.items.size() <= SPACE;
    }

    public boolean verifyElements(ArrayList<Item> items) {
        for (Item item : items) {
            if (!item.getName().equals(items.get(0).getName())) {
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
