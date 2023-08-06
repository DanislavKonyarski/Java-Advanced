package christmasPastryShop.entities.booths.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

import static christmasPastryShop.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static christmasPastryShop.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        this.boothNumber = boothNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
            this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        isReserved = true;
        setNumberOfPeople(numberOfPeople);
        this.price = numberOfPeople*pricePerPerson;

    }

    @Override
    public double getBill() {
        double bill = delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        bill += cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        return bill;
    }

    @Override
    public void clear() {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        isReserved = false;
        numberOfPeople=0;


    }
}
