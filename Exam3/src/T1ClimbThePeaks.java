import java.util.*;

public class T1ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> foodPortionStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(foodPortionStack::push);
        ArrayDeque<Integer> dailyStaminaQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(dailyStaminaQueue::offer);
        ArrayDeque<Integer> difficultyLevelQueue = new ArrayDeque<>();
        difficultyLevelQueue.offer(80);
        difficultyLevelQueue.offer(90);
        difficultyLevelQueue.offer(100);
        difficultyLevelQueue.offer(60);
        difficultyLevelQueue.offer(70);
        ArrayDeque<String> mountainPeaksQueue = new ArrayDeque<>();
        mountainPeaksQueue.offer("Vihren");
        mountainPeaksQueue.offer("Kutelo");
        mountainPeaksQueue.offer("Banski Suhodol");
        mountainPeaksQueue.offer("Polezhan");
        mountainPeaksQueue.offer("Kamenitza");
        List<String> conqueredPeakList = new ArrayList<>();

        while (foodPortionStack.size()!=0&&difficultyLevelQueue.size()!=0){
            int currentFood = foodPortionStack.pop();
            int currentSttamina = dailyStaminaQueue.poll();
            int currentDifficulLevel = difficultyLevelQueue.peek();
            String currentPeaks = mountainPeaksQueue.peek();
            if (currentFood+currentSttamina>=currentDifficulLevel){
               conqueredPeakList.add(currentPeaks);
               difficultyLevelQueue.poll();
               mountainPeaksQueue.poll();
            }
        }
        if (conqueredPeakList.size()==5){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }if (conqueredPeakList.size()!=0){
            System.out.println("Conquered peaks:");
            conqueredPeakList.forEach(System.out::println);
        }
    }
}
