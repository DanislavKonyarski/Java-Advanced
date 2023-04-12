import java.util.*;

public class T2BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> finalNumber = new ArrayDeque<>();
        PriorityQueue<Integer> smallerNumber = new PriorityQueue<>();
        for (int i = 0; i < command[0]-command[1]; i++) {
            finalNumber.push(numbers[i]);
        }
        if (finalNumber.contains(command[2])){
            System.out.println("true");
        } else if (finalNumber.size()==0) {
            System.out.println(0);
        }else {
            for (Integer integer : finalNumber) {
                smallerNumber.offer(integer);
            }
            System.out.println(smallerNumber.poll());
        }
    }
}
