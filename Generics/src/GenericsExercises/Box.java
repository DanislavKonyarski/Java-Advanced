package GenericsExercises;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> element;

    public Box() {
        this.element = new ArrayList<>();

    }

    public List<T> getElement() {
        return element;
    }

    public void setElement(List<T> element) {
        this.element = element;
    }
    public void add(T element){
        this.element.add(element);
    }
    public int size (){
        return element.size();
    }
    public void swap (int firstIndex, int secondIndex){
        T currentElement = element.get(firstIndex);
        element.set(firstIndex,element.get(secondIndex));
        element.set(secondIndex,currentElement);
    }
    public int greater (T elementForCompare){
        return (int) this.element.stream().filter(e -> e.compareTo(elementForCompare)>0).count();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        element.forEach(e ->stringBuilder.append(String.format("%s: %s%n",e.getClass().getName(),e)));
        return stringBuilder.toString();
    }
}
