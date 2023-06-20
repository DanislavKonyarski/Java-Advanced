package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Animal animal){
        if (this.data.size()<this.capacity){
            this.data.add(animal);
        }
    }
    public boolean remove(String name){
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)){
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Animal getAnimal(String name, String caretaker){
        return this.data.stream().filter(e->e.getName().equals(name)&&e.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }
    public Animal getOldestAnimal(){
        return this.data.stream().sorted((f,s)->s.getAge()-f.getAge()).findFirst().orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The shelter has the following animals:\n");
        this.data.stream().forEach(e-> stringBuilder.append(e.getName()+" "+e.getCaretaker()+"\n"));
        return String.valueOf(stringBuilder);
    }
}
