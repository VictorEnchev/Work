package collections.hashdice;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int side = Integer.parseInt(SCANNER.nextLine());
        int rolls = Integer.parseInt(SCANNER.nextLine());
        int diceGoal1 = Integer.parseInt(SCANNER.nextLine());
        int diceGoal2 = Integer.parseInt(SCANNER.nextLine());

        Controller controller = new Controller(side);
        controller.play(diceGoal1, diceGoal2, rolls);
    }
}
