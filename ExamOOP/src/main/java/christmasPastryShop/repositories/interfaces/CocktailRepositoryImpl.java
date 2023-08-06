package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.ArrayList;
import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail>{

    private Collection<Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return cocktails.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return cocktails;
    }

    @Override
    public void add(Cocktail cocktail) {
        cocktails.add(cocktail);
    }
}
