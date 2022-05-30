package Model;

import Game.Inventory;

import java.util.ArrayList;

public class Entity {
    private double health;
    private Inventory inventory;
    private double strength;
    private double mana;

    public Entity(double health, Inventory inventory, double strength, double mana) {
        this.health = health;
        this.inventory = inventory;
        this.strength = strength;
        this.mana = mana;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public double getStrength() {
        return this.strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getMana() {
        return this.mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }
}
