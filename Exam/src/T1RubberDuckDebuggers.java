import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class T1RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> programmer = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(programmer :: offer);

        ArrayDeque<Integer> task = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(task::push);

//        Darth Vader Ducky	0 - 60
//        Thor Ducky	61 – 120
//        Big Blue Rubber Ducky	121 - 180
//        Small Yellow Rubber Ducky	181 - 240

        int countVaderDucky = 0;
        int countThorDucky = 0;
        int countBlueRubberDucky = 0;
        int countYellowRubberDucky = 0;

        while (programmer.size()!=0){
            int command = programmer.peek() * task.peek();
            if (command<=60){
                countVaderDucky++;
                programmer.poll();
                task.pop();
            } else if (command<=120) {
                countThorDucky++;
                programmer.poll();
                task.pop();
            } else if (command<=180) {
                countBlueRubberDucky++;
                programmer.poll();
                task.pop();
            } else if (command<=240) {
                countYellowRubberDucky++;
                programmer.poll();
                task.pop();
            } else if (command>240) {
                int currentProgramer = programmer.poll();
                programmer.offer(currentProgramer);
                int currentTask = task.poll()-2;
                task.push(currentTask);
            }
        }
        System.out.printf("Congratulations, all tasks have been completed! Rubber ducks rewarded:%nDarth Vader Ducky: %d%n" +
                        "Thor Ducky: %d%nBig Blue Rubber Ducky: %d%nSmall Yellow Rubber Ducky: %d",
                countVaderDucky,countThorDucky,countBlueRubberDucky,countYellowRubberDucky);
    }
}
