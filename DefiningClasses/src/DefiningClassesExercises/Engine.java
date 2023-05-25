package DefiningClassesExercises;

public class Engine {
    private String modelEngine;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String modelEngine, int power) {
        this.modelEngine = modelEngine;
        this.power = power;
    }

    public Engine(String modelEngine, int power, int displacement) {
        this(modelEngine,power);
        this.displacement = displacement;
    }

    public Engine(String modelEngine, int power, String efficiency) {
      this(modelEngine,power);
        this.efficiency = efficiency;
    }

    public Engine(String modelEngine, int power, int displacement, String efficiency) {
        this(modelEngine,power,displacement);
        this.efficiency = efficiency;
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
