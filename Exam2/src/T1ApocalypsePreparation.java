import javax.sound.midi.Patch;
import java.util.*;

public class T1ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> textiles = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(textiles::offer);
        ArrayDeque<Integer> medicament = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(medicament::push);
        Map<String, Integer> items = new TreeMap<>();
        items.put("Patch", 0);
        items.put("Bandage", 0);
        items.put("MedKit", 0);
//        int countPatch = 0;
//        int countBandage = 0;
//        int countMedKit = 0;
        while (textiles.size() != 0 && medicament.size() != 0) {
            int currentTextile = textiles.peek();
            int currentMedicament = medicament.peek();
            if (currentMedicament + currentTextile == 30) {
                items.put("Patch", items.get("Patch") + 1);
                textiles.poll();
                medicament.pop();
            } else if (currentMedicament + currentTextile == 40) {
                items.put("Bandage", items.get("Bandage") + 1);
                textiles.poll();
                medicament.pop();
            } else if (currentMedicament + currentTextile == 100) {
                items.put("MedKit", items.get("MedKit") + 1);
                textiles.poll();
                medicament.pop();
            } else if (currentMedicament + currentTextile > 100) {
                items.put("MedKit", items.get("MedKit") + 1);
                textiles.poll();
                medicament.pop();
                int currentSum = ((currentMedicament + currentTextile) - 100) + medicament.pop();
                medicament.push(currentSum);
            } else {
                textiles.poll();
                int currentSum = medicament.pop() + 10;
                medicament.push(currentSum);
            }
        }


        List<Map.Entry<String, Integer>> orderedItems = new ArrayList<>(items.entrySet());
        Collections.sort(orderedItems,
                Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().
                        thenComparing(Map.Entry<String, Integer>::getKey));

        if (textiles.size() == 0 && medicament.size() == 0) {
            System.out.println("Textiles and medicaments are both empty.");
            orderedItems.stream().filter(e -> e.getValue() != 0).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        } else if (textiles.size() == 0) {
            System.out.println("Textiles are empty.");
            orderedItems.stream().filter(e -> e.getValue() != 0).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
            System.out.print("Medicaments left: "+medicament.toString().replace("[","").replace("]",""));
        } else if (medicament.size() == 0) {
            System.out.println("Medicaments are empty.");
            orderedItems.stream().filter(e -> e.getValue() != 0).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
            System.out.print("Textiles left: "+textiles.toString().replace("[","").replace("]",""));
        }
    }
}
