import Game.Battle;
import Game.Inventory;
import Model.Monster;
import Model.Player;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start game? ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no") ||
                response.equalsIgnoreCase("")) {
            System.out.println("Looks like you're not ready to go adventuring!");
            System.exit(1);
        }
        Player player = new Player(100, new Inventory(0.0, new ArrayList<String>()), 10, 0);
        System.out.println("Let's begin!");
        wait(1000);
        int wave = 1;
        while (true) {
            // Check to see if player is dead
            if (player.isDead()) {
                wait(1000);
                System.out.println("You are dead!");
                wait(1000);
                System.out.println("Better luck next time! You can always try again :)");
                break;
            }
            // Start the wave
            System.out.println("Starting wave " + wave + "\n");
            wait(1000);

            // Begin battle
            Monster monster = new Monster();
            System.out.println("You are fighting " + monster.getName() + "\n");
            wait(1000);
            Battle.beginBattle(player, monster);

            // End of battle
            System.out.println("You have gained " + wave + " strength!");
            player.setStrength(player.getStrength()+1);
            wait(1000);

            // End the wave
            System.out.println("Ending wave " + wave + "\n");
            wave++;
            wait(1000);
        }
        System.out.println("Thanks for playing!");
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
