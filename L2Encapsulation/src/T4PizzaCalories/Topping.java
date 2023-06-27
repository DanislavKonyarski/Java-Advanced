package T4PizzaCalories;

public class Topping {

    //+	calculateCalories (): double
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if ("Meat".equals(toppingType) || "Veggies".equals(toppingType)
                || "Cheese".equals(toppingType) || "Sauce".equals(toppingType)) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        } else {
            this.weight = weight;
        }
    }

    public double calculateCalories() {
        double toppingCalories = 2 * weight;
        if ("Meat".equals(toppingType)) {
            toppingCalories *= 1.2;
        } else if ("Veggies".equals(toppingType)) {
            toppingCalories *= 0.8;
        } else if ("Cheese".equals(toppingType)) {
            toppingCalories *= 1.1;
        } else if ("Sauce".equals(toppingType)) {
            toppingCalories *= 0.9;
        }
        return toppingCalories;
    }

}
