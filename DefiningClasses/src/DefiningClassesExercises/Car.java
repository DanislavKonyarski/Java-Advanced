package DefiningClassesExercises;

public class Car {
    private String modelCar;
    private Engine engine;
    private int weight;
    private  String color;

    public Car(String modelCar,Engine engine) {
        this.modelCar = modelCar;
        this.engine = engine;

    }
    public Car(String modelCar,Engine engine,int weight){
        this(modelCar,engine);
        this.weight = weight;
    }
    public Car(String modelCar,Engine engine,String color){
        this(modelCar,engine);
        this.color = color;
    }
    private Car(String modelCar,Engine engine,int weight, String color){
        this(modelCar,engine,weight);
        this.color = color;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
//{CarModel}:
//{EngineModel}:
//Power: {EnginePower}
//Displacement: {EngineDisplacement}
//Efficiency: {EngineEfficiency}
//Weight: {CarWeight}
//Color: {CarColor}
    @Override
    public String toString() {
        String displacement = "";
        if (engine.getDisplacement()==0){
            displacement = "n/a";
        }else {
            displacement = String.valueOf(engine.getDisplacement());
        }
        if (engine.getEfficiency()==null){
            engine.setEfficiency("n/a");
        }
        String carWeight = "";
        if (weight==0){
            carWeight="n/a";
        }else {
            carWeight = String.valueOf(weight);
        }
        if (color==null){
            color = "n/a";
        }
        return String.format("%s:%n%s:%nPower: %s%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s",
                modelCar,engine.getModelEngine(),engine.getPower(),
                displacement,engine.getEfficiency(),carWeight,color);
    }
}
