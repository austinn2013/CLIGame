package Game;

import Model.Entity;
import Model.Monster;
import Model.Player;

import java.util.Scanner;

public class Battle {

    public Battle(Player player, Monster monster, boolean hasStarted) {
        if (hasStarted) {
            beginBattle(player, monster);
        }
        else {
            System.out.println("Awaiting for battle...");
            // Add more functionality here i.e. events, resting period...
        }
    }

    public static void beginBattle(Player player, Monster monster) {
        try {
            switch (monster.getName()) {
                case "Skeleton":
                    monster.setHealth(150);
                    monster.setStrength(3);
                    monster.setMana(0);
                    break;
                case "Zombie":
                    monster.setHealth(100);
                    monster.setStrength(5);
                    monster.setMana(0);
                    break;
                case "Dragon":
                    monster.setHealth(200);
                    monster.setStrength(5);
                    monster.setMana(50);
                    break;
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        boolean pTurn = false;
        boolean mTurn = false;
        int determineTurn = (int)(Math.random() * 2);
        // Determine turns: monster or player first
        switch (determineTurn) {
            case 0:
                pTurn = true;
            case 1:
                mTurn = true;
        }
        while(!isDone(player, monster)) {
            if (pTurn) {
                showMenu();
                Scanner getAction = new Scanner(System.in);
                int action = getAction.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("\nPlayer attacks " + monster.getName());
                        monster.receiveDamage(player.getStrength());
                        System.out.println(monster.getName() + " takes " + player.getStrength() + " damage!");
                        System.out.println(monster.getName() + " has " + monster.getHealth() + " hp\n");
                        break;
                    case 2:
                        player.getInventory().showInventory();
                        System.out.print("\nWhich item do you want to use? ");
                        continue;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\nYou have skipped your turn\n");
                        break;
                }
                pTurn = false;
                mTurn = true;
            }
            else {
                System.out.println(monster.getName() + " attacks Player");
                player.receiveDamage(monster.getStrength());
                System.out.println("Player takes " + monster.getStrength() + " damage!");
                System.out.println("Player has " + player.getHealth() + " hp\n");
                pTurn = true;
                mTurn = false;
            }
        }
        isWinner(player, monster);
    }

    public static void isWinner(Player player, Monster monster) {
        if (player.isDead()) {
            System.out.println(monster.getName() + " is the winner!");
        }
        else {
            System.out.println("Player is the winner!");
        }
    }

    public static boolean isDone(Player player, Monster monster) {
        return player.isDead() || monster.isDead();
    }

    public static void showMenu() {
        System.out.println("1. Attack                |                 2. Inventory");
        System.out.println("=========================================================");
        System.out.println("3. Spells                |                 4. Skip");
        System.out.print("\nWhat do you want to do? ");
    }
}
