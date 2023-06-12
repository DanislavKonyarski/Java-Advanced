import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ListyIterator listyIterator = null;
        while (!input.equals("END")) {
            if (input.split("\\s+")[0].equals("Create")) {
                if (input.split("\\s+").length == 1) {
                    listyIterator = new ListyIterator();
                } else {
                    String[] elementForInput = Arrays.copyOfRange(input.split("\\s+"),
                            1, input.split("\\s+").length);
                    listyIterator = new ListyIterator(elementForInput);
                }
            } else if (input.equals("Move")) {
                System.out.println(listyIterator.move());
            } else if (input.equals("HasNext")) {
                System.out.println(listyIterator.hasNext());
            } else if (input.equals("Print")) {
                try {

                    listyIterator.print();
                } catch (IllegalAccessException e) {
                    System.out.println("Invalid Operation!");
                }

            } else if (input.equals("PrintAll")) {
                listyIterator.forEach(e -> System.out.printf("%s ",e));
                System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
