package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    //•	name: String
    //•	capacity: int
    //•	registry: List<Child>
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }

    public void setRegistry(List<Child> registry) {
        this.registry = registry;
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        boolean flag = false;
        for (int i = 0; i < registry.size(); i++) {
            if (registry.get(i).getFirstName().equals(firstName)) {
                registry.remove(i);
                i--;
                flag = true;
            }
        }
        return flag;
    }
    public int getChildrenCount(){
        return registry.size();
    }
    public Child getChild(String firstName) {
        return registry.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport()  {
        Collections.sort(registry, Comparator.comparing(Child::getAge).thenComparing(Child::getFirstName).
                thenComparing(Child::getLastName));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Registered children in %s:%n--%n",name));
        for (int i = 0; i < registry.size(); i++) {
            stringBuilder.append(registry.get(i));
            stringBuilder.append("\n");
            if (i==registry.size()-1){
                break;
            }
            stringBuilder.append("--\n");

        }
        return String.valueOf(stringBuilder);
    }
}
