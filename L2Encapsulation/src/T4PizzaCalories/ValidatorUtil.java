package T4PizzaCalories;

import java.util.Arrays;

public class ValidatorUtil {
    public static void validatePizzaName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 1 || name.trim().length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void validateNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings < 1 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public static void validateFlourType(String type) {
        if (!"White".equalsIgnoreCase(type) && !"Wholegrain".equalsIgnoreCase(type)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateDoughWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equalsIgnoreCase(bakingTechnique) && !"Chewy".equalsIgnoreCase(bakingTechnique)
                && !"Homemade".equalsIgnoreCase(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public static void validateToppingWeight(String toppingType, double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
    }

    public static void validateToppingType(String toppingType) {
        String[] listOfValidToppings = {"Meat", "Veggies", "Cheese", "Sauce"};
        if (!Arrays.asList(listOfValidToppings).contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }
}
