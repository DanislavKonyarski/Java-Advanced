package T1harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] field = clazz.getDeclaredFields();
        String input = scanner.nextLine();
        while (!"HARVEST".equals(input)) {
            switch (input) {
                case "private":
                    Arrays.stream(field).filter(f -> Modifier.isPrivate(f.getModifiers())).
                            forEach(f -> System.out.printf(("%s %s %s%n"), Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(), f.getName()));
                    break;
                case "protected":
                    Arrays.stream(field).filter(f -> Modifier.isProtected(f.getModifiers())).
                            forEach(f -> System.out.printf(("%s %s %s%n"), Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(), f.getName()));
                    break;
                case "public":
                    Arrays.stream(field).filter(f -> Modifier.isPublic(f.getModifiers())).
                            forEach(f -> System.out.printf(("%s %s %s%n"), Modifier.toString(f.getModifiers()),
                                    f.getType().getSimpleName(), f.getName()));
                    break;
                case "all":
                    Arrays.stream(field).forEach(f -> System.out.printf(("%s %s %s%n"),
                            Modifier.toString(f.getModifiers()),
                                f.getType().getSimpleName(), f.getName()));
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
