package DefiningClassesExercises;

public class Car {
    private String modelCar;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String modelCar, Engine engine, Cargo cargo, Tire tire) {
        this.modelCar = modelCar;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }
}
