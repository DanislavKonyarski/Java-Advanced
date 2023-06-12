package magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Magazine {
    private List<Cloth> clothList;
    private String type;
    private int capacity;

    public Magazine(String type, int capacity) {
        this.clothList = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }


    public void addCloth(Cloth cloth) {
        if (capacity > clothList.size()) {
            clothList.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        Cloth cloth = this.getCloth(color);
        clothList.remove(cloth);
        return cloth != null;
    }

    public Cloth getSmallestCloth() {
        return clothList.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);

    }

    public Cloth getCloth(String color) {
        return clothList.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return clothList.size();
    }

    public String report() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s magazine contains:%n", type)).trimToSize();

        clothList.forEach(egg -> sb.append(egg.toString()).append(String.format("%n")));

        return sb.toString().trim();
    }
}

