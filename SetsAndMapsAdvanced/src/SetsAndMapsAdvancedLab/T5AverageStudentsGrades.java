package SetsAndMapsAdvancedLab;

import java.util.*;

public class T5AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countInput = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentGradeMap = new TreeMap<>();

        for (int i = 0; i < countInput; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String student = input[0];
            double grade = Double.parseDouble(input[1]);

            studentGradeMap.putIfAbsent(student, new ArrayList<>());
            studentGradeMap.get(student).add(grade);
        }
        for (Map.Entry<String, List<Double>> entry : studentGradeMap.entrySet()) {
            String student = entry.getKey();
            double sum = 0 ;
            System.out.printf("%s -> ",student);
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
                System.out.printf("%.2f ",entry.getValue().get(i));
            }
            double grade = sum/entry.getValue().size();
            System.out.printf("(avg: %.2f)%n",grade);
        }

    }
}
