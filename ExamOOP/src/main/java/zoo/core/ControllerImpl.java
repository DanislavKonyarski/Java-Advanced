package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        if ("WaterArea".equals(areaType)) {
            WaterArea waterArea = new WaterArea(areaName);
            areas.add(waterArea);
            return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
        } else if ("LandArea".equals(areaType)) {
            LandArea landArea = new LandArea(areaName);
            areas.add(landArea);
            return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
    }

    @Override
    public String buyFood(String foodType) {
        if ("Vegetable".equals(foodType)) {
            Vegetable vegetable = new Vegetable();
            foodRepository.add(vegetable);
            return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
        } else if ("Meat".equals(foodType)) {
            Meat meat = new Meat();
            foodRepository.add(meat);
            return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        } else {
            areas.stream().filter(e -> e.getName().equals(areaName)).forEach(e -> e.addFood(food));
            foodRepository.remove(food);
            return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
        }
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = areas.stream().filter(e -> e.getName().equals(areaName)).findFirst().orElse(null);
        if (animalType.equals("AquaticAnimal")) {
            if (area.getClass().getSimpleName().equals("WaterArea")) {
                AquaticAnimal aquaticAnimal = new AquaticAnimal(animalName, kind, price);
                areas.stream().filter(e -> e.getName().equals(areaName)).forEach(e -> e.addAnimal(aquaticAnimal));
                return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
            }
            return AREA_NOT_SUITABLE;
        } else if (animalType.equals("TerrestrialAnimal")) {
            if (area.getClass().getSimpleName().equals("LandArea")) {
                TerrestrialAnimal terrestrialAnimal = new TerrestrialAnimal(animalName, kind, price);
                areas.stream().filter(e -> e.getName().equals(areaName)).forEach(e -> e.addAnimal(terrestrialAnimal));
                return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
            }
            return AREA_NOT_SUITABLE;
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
    }

    @Override
    public String feedAnimal(String areaName) {
        int count = 0;
        for (Area area : areas) {
            if (area.getName().equals(areaName)) {
                for (Animal animal : area.getAnimals()) {
                    animal.eat();
                    count++;
                }
            }
        }
        return String.format(ANIMALS_FED,count);
    }

    @Override
    public String calculateKg(String areaName) {
        double kilograms = 0;
        for (Area area : areas) {
            if (area.getName().equals(areaName)){
                kilograms = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
            }
        }
        return String.format(KILOGRAMS_AREA,areaName,kilograms);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        areas.forEach(e->sb.append(e.getInfo()).append(System.lineSeparator()));
        return String.valueOf(sb).trim();
    }
}
