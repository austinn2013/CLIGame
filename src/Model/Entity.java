package Model;

import Game.Inventory;

import java.util.ArrayList;

public class Entity {
    private int health;
    private Inventory inventory;
    private int strength;
    private double mana;

    public Entity(int health, Inventory inventory, int strength, double mana) {
        this.health = health;
        this.inventory = inventory;
        this.strength = strength;
        this.mana = mana;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getMana() {
        return this.mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public void receiveDamage(int damage) {
        this.health = this.health - damage;
    }
}
