import java.util.*;

public class T3MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommand = Integer.parseInt(scanner.nextLine());
        Deque<Long> numbersStack = new ArrayDeque<>();
        PriorityQueue<Long> maxNumber = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < countCommand; i++) {
            long[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
            Long command = input[0];
            if (command==1){
                numbersStack.push(input[1]);
            } else if (command==2) {
                numbersStack.pop();
            } else if (command==3) {
                for (Long integer : numbersStack) {
                    maxNumber.offer(integer);
                }
                System.out.println(maxNumber.poll());
                maxNumber.clear();
            }
        }
    }
}
