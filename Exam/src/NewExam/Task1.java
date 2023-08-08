package NewExam;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeinе = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(caffeinе::push);

        ArrayDeque<Integer> drinks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(drinks::offer);

        int maxCaffeine = 300;

        while (caffeinе.size() != 0 && drinks.size() != 0 && maxCaffeine >= 0) {
            int currentDrink = drinks.poll();
            int currentCaffeine = caffeinе.pop() * currentDrink;
            if (currentCaffeine > maxCaffeine) {
                drinks.offer(currentDrink);
                maxCaffeine += 30;
                if (maxCaffeine > 300) {
                    maxCaffeine = 300;
                }
            }else {
                maxCaffeine-=currentCaffeine;
            }
        }
        if (drinks.size()>0){
            System.out.println("Drinks left:"+drinks.toString().replace("["," ").replace("]",""));
            System.out.printf("Stamat is going to sleep with %d mg caffeine.",300-maxCaffeine);
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
            System.out.printf("Stamat is going to sleep with %d mg caffeine.",300-maxCaffeine);
        }
    }
}
