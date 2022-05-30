package Game;

public class Item {
    private String name;
    private int strength;
    private int health;

    public Item(String name, int strength, int health) {
        if (name.equals("Sword")) {
            this.name = name;
            this.strength = strength;
        }
        else if (name.equals("Potion")) {
            this.name = name;
            this.health = health;
        }
    }
}
