package GenericsExercises;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    //•	Add {element} - Adds the given element to the end of the list.
//•	Remove {index} - Removes the element at the given index.
//•	Contains {element} - Prints if the list contains the given element (true or false).
//•	Swap {index1} {index2} - Swaps the elements at the given indexes.
//•	Greater {element} - Counts the elements that are greater than the given element and prints their count
//•	Max - Prints the maximum element in the list.
//•	Min - Prints the minimum element in the list.
//•	Print - Prints all elements in the list, each on a separate line.
//•	END - stops the reading of commands.
    public void add(T element) {
        customList.add(element);
    }

    public void remove(int index) {
        customList.remove(index);
    }

    public boolean contains(T element) {
      return customList.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T currentElement = customList.get(firstIndex);
        customList.set(firstIndex, customList.get(secondIndex));
        customList.set(secondIndex, currentElement);
    }

    public int greater(T element) {
        return (int) customList.stream().filter(e -> e.compareTo(element) > 0).count();
    }
    public T max (){
       return customList.stream().max((f,s)-> f.compareTo(s)).get();
    }
    public T min (){
        return customList.stream().min((f,s)-> f.compareTo(s)).get();
    }
    public void sort (){
        customList.sort(Comparable::compareTo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        customList.forEach(e ->sb.append(String.format("%s%n",e)));
        return sb.toString().trim();
    }
}
