package T2blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        String input = scanner.nextLine();

        Field field = clazz.getDeclaredField("innerValue");
        field.setAccessible(true);

        while (!"END".equals(input)){
            String command = input.split("_")[0];
            int number = Integer.parseInt(input.split("_")[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt , number);

            System.out.println(field.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}
