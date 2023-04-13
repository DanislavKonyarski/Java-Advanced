import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class T9PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPlants = Integer.parseInt(scanner.nextLine());
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> plants = new ArrayDeque<>();
        for (int i = 0; i < countPlants; i++) {
            plants.push(input[i]);
        }
        int currentSize = plants.size();
        int count=0;
        while (currentSize!=0){
            Deque<Integer> currentPlants = new ArrayDeque<>();
            for (int i = 1; i < currentSize; i++) {
                int plantLast = plants.pop();
                int plantPreLast = plants.peek();
                if (plantLast<=plantPreLast){
                   currentPlants.push(plantLast);
                }
            }
                currentPlants.push(plants.pop());
            if (currentSize==currentPlants.size()){
                currentSize = 0;
                break;
            }else {
                currentSize = currentPlants.size();
            }
            for (int i = 0; i < currentSize; i++) {
                plants.push(currentPlants.pop());
            }
            count++;
        }
        System.out.println(count);
    }
}
