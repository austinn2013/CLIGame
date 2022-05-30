package Model;

public class Monster extends Entity {
    private String name;
    private final String[] monsters = {"Skeleton", "Zombie", "Dragon"};

    public Monster() {
        super(0, null, 0, 0);
        this.name = this.monsters[(int)(Math.random() * (this.monsters.length))];
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
