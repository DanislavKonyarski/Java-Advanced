package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth>{


    private Collection<Booth> booths;

    public BoothRepositoryImpl (){
        this.booths = new ArrayList<>();
    }
    @Override
    public Booth getByNumber(int number) {
        return booths.stream().filter(e-> e.getBoothNumber()==number).findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return booths;
    }

    @Override
    public void add(Booth booth) {
        booths.add(booth);
    }
}
