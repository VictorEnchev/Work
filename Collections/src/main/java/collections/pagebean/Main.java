package collections.pagebean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7"));
        Distributor distributor = new Distributor(items, 2);

        String command = scanner.nextLine();
        while(command != null){
            switch (command) {
                case "next" -> distributor.next();
                case "previous" -> distributor.previous();
                case "hasNext" -> distributor.hasNext();
                case "hasPrevious" -> distributor.hasPrevious();
                case "firstPage" -> distributor.firstPage();
                case "lastPage" -> distributor.lastPage();
                case "getCurrentPageNumber" -> distributor.getCurrPageNumber();
            }
            command = scanner.nextLine();
        }
    }
}
