package T4PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if ("White".equals(flourType) || "Wholegrain".equals(flourType)) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if ("Crispy".equals(bakingTechnique) || "Chewy".equals(bakingTechnique) || "homemade".equals(bakingTechnique)){
            this.bakingTechnique = bakingTechnique;
        }else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight>=0&&weight<=200){
        this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double calculateCalories (){
        double caloriesDough = 2*weight;
        if ("White".equals(flourType)){
            caloriesDough*=1.5;
        }
        if ("Crispy".equals(bakingTechnique)) {
            caloriesDough*=0.9;
        } else if ("Chewy".equals(bakingTechnique)) {
            caloriesDough*=1.1;
        }
        return caloriesDough;
    }

}
