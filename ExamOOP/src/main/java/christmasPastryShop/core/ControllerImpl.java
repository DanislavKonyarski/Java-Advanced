package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;
import christmasPastryShop.repositories.interfaces.Repository;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private  double income;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        for (Delicacy delicacy : delicacyRepository.getAll()) {
            if (delicacy.getName().equals(name)) {
                throw new IllegalArgumentException(FOOD_OR_DRINK_EXIST);
            }
        }
        if ("Stolen".equals(type)) {
            Stolen stolen = new Stolen(name, price);
            delicacyRepository.add(stolen);
            return String.format(DELICACY_ADDED, name, type);
        } else if ("Gingerbread".equals(type)) {
            Gingerbread gingerbread = new Gingerbread(name, price);
            delicacyRepository.add(gingerbread);
            return String.format(DELICACY_ADDED, name, type);
        }
        return null;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        for (Cocktail cocktail : cocktailRepository.getAll()) {
            if (cocktail.getName().equals(name)) {
                throw new IllegalArgumentException(FOOD_OR_DRINK_EXIST);
            }
        }
        if ("MulledWine".equals(type)) {
            MulledWine mulledWine = new MulledWine(name, size, brand);
            cocktailRepository.add(mulledWine);
            return String.format(COCKTAIL_ADDED, name, brand);
        } else if ("Hibernation".equals(type)) {
            Hibernation hibernation = new Hibernation(name, size, brand);
            cocktailRepository.add(hibernation);
            return String.format(COCKTAIL_ADDED, name, brand);
        }
        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        for (Booth booth : boothRepository.getAll()) {
            if (booth.getBoothNumber() == boothNumber) {
                throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
            }
        }
        if ("OpenBooth".equals(type)) {
            OpenBooth openBooth = new OpenBooth(boothNumber, capacity);
            boothRepository.add(openBooth);
            return String.format(BOOTH_ADDED, boothNumber);
        } else if ("PrivateBooth".equals(type)) {
            PrivateBooth privateBooth = new PrivateBooth(boothNumber, capacity);
            boothRepository.add(privateBooth);
            return String.format(BOOTH_ADDED, boothNumber);
        }
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        for (Booth booth : boothRepository.getAll()) {
            if (booth.getCapacity() >= numberOfPeople && !booth.isReserved()) {
                booth.reserve(numberOfPeople);
                return String.format(BOOTH_RESERVED,booth.getBoothNumber(),numberOfPeople);
            }
        }
        return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        for (Booth booth  : boothRepository.getAll() ) {
            if (booth.getBoothNumber()==boothNumber){
                income+=booth.getPrice();
                String returnMessage = String.format("Booth: %d%nBill: %.2f",boothNumber,booth.getPrice());
                booth.clear();
                return returnMessage;
            }
        }
        return null;
    }

    @Override
    public String getIncome() {

        return String.format("Income: %.2flv",income);
    }
}
