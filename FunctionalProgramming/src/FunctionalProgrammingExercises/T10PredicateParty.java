package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Party!")){
            String firstCommand = command.split("\\s+")[0];
            String secondCommand = command.split("\\s+")[1];
            String treeCommand = command.split("\\s+")[2];

            if (firstCommand.equals("Double")){
                switch (secondCommand){
                    case "StartsWith":
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).startsWith(treeCommand)){
                                names.add(i,names.get(i++));
                            }
                        }

                        break;
                    case "EndsWith":
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).endsWith(treeCommand)){
                                names.add(i,names.get(i++));
                            }
                        }
                        break;
                    case "Length":
                        int currentTreeCommand = Integer.parseInt(treeCommand);
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).length() == currentTreeCommand){
                                names.add(i,names.get(i++));
                            }
                        }
                        break;
                }
            } else if (firstCommand.equals("Remove")) {
                switch (secondCommand){
                    case "StartsWith":
                        names.removeIf(e -> e.startsWith(treeCommand));
                        break;
                    case "EndsWith":
                        names.removeIf(e -> e.endsWith(treeCommand));
                        break;
                    case "Length":
                        int currentTreeCommand = Integer.parseInt(treeCommand);
                        names.removeIf(e -> e.length()==currentTreeCommand);
                        break;

                }
            }
            command=scanner.nextLine();
        }
        Collections.sort(names);
        if (names.size()>0){
        System.out.print(String.join(", ", names));
        System.out.print(" are going to the party!");
        }else {
            System.out.println("Nobody is going to the party!");
        }
    }
}
