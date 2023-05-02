package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class T8AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentAverageMap = new TreeMap<>();
        for (int i = 0; i < countInput; i++) {
            String student = scanner.nextLine();
            List<Double> currentList = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());
            studentAverageMap.putIfAbsent(student, new ArrayList<>());
            for (Double aDouble : currentList) {
                studentAverageMap.get(student).add(aDouble);
            }

        }
        for (Map.Entry<String, List<Double>> entry : studentAverageMap.entrySet()) {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum+=entry.getValue().get(i);
            }
            double average = sum/entry.getValue().size();
            DecimalFormat decimalFormat = new DecimalFormat("#.##################");
            System.out.printf("%s is graduated with %s%n",entry.getKey(),decimalFormat.format(average));
        }

    }
}
