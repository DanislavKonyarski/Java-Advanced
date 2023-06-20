import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> toolsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(toolsQueue::offer);
        ArrayDeque<Integer> sequenceStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(sequenceStack::push);
        List<Integer> challengesList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        while (toolsQueue.size() != 0 && sequenceStack.size() != 0 && challengesList.size() != 0) {
            int currentTool = toolsQueue.poll();
            int currentSequence = sequenceStack.pop();
            boolean flag = true;
            for (int i = 0; i < challengesList.size(); i++) {
                if (currentSequence * currentTool == challengesList.get(i)) {
                    flag = false;
                    challengesList.remove(i);
                    break;
                }
            }
            if (flag) {
                toolsQueue.offer(currentTool + 1);
                if (currentSequence - 1 > 0) {
                    sequenceStack.push(currentSequence - 1);
                }
            }
        }
        if (challengesList.size() != 0) {
            System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        } else {
            System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
        }
        if (toolsQueue.size() != 0) {
            System.out.println("Tools: " + toolsQueue.toString().replace("[", "").replace("]", ""));
        }
        if (sequenceStack.size() != 0) {
            System.out.println("Substances: " + sequenceStack.toString().replace("[", "").replace("]", ""));
        }
        if (challengesList.size() != 0) {
            System.out.println("Challenges: " + challengesList.toString().replace("[", "").replace("]", ""));
        }
    }
}
