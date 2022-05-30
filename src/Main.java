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
    }
}
