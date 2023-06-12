import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ListyIterator implements Iterable {
    private List<String> list;
    private int index;

    public ListyIterator(String... element) {
        this.list = List.of(element);
        this.index = 0;
    }

    public List<String> getList() {
        return list;
    }

    public int getIndex() {
        return index;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    public void create (String... element){
        this.list = Arrays.stream(element).collect(Collectors.toList());
    }
    public void print() throws IllegalAccessException {
        if (list.size()<=index){
            throw new IllegalAccessException("Invalid Operation!");
        }else {
            System.out.println(list.get(index));
        }
    }
    public boolean move (){
        if (list.size()>index){
            index++;
            return true;
        }else {
            return false;
        }
    }
    public boolean hasNext (){
        if (list.size()>index+1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int internalIndex;
            @Override
            public boolean hasNext() {
                return internalIndex < list.size();
            }

            @Override
            public String next() {
                String element = list.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }
}
