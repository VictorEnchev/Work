package threads.timeouthashtable;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeoutHashtable table = new TimeoutHashtable(20);

        String input = scanner.nextLine();
        while(!input.equals("End")){
            String[] splitInput = input.split(" ");
            switch (splitInput[0]) {
                case "Put" -> table.put(splitInput[1], splitInput[2]);
                case "Get" -> table.get(splitInput[1]);
                case "Remove" -> table.remove(splitInput[1]);
            }
            input = scanner.nextLine();
        }
    }
}
