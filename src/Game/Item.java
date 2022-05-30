package Game;

public class Item {
    private String name;
    private int strength;
    private int health;

    public Item(String name) {
        if (name.equals("Sword")) {
            this.name = name;
            this.strength = 5;
        }
        else if (name.equals("Potion")) {
            this.name = name;
            this.health = 10;
        }
        else {
            this.name = "Empty slot";
        }
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHealth() {
        return this.health;
    }
}
