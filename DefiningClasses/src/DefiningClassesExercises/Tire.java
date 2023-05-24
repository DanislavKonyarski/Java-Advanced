package DefiningClassesExercises;

public class Tire {
    private Double tire1Pressure;
    private int tire1Age;
    private Double tire2Pressure;
    private int tire2Age;
    private Double tire3Pressure;
    private int tire3Age;
    private Double tire4Pressure;
    private  int tire4Age;

    public Tire(Double tire1Pressure, int tire1Age, Double tire2Pressure,
                int tire2Age, Double tire3Pressure, int tire3Age, Double tire4Pressure, int tire4Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
        this.tire3Pressure = tire3Pressure;
        this.tire3Age = tire3Age;
        this.tire4Pressure = tire4Pressure;
        this.tire4Age = tire4Age;
    }

    public Double getTire1Pressure() {
        return tire1Pressure;
    }

    public void setTire1Pressure(Double tire1Pressure) {
        this.tire1Pressure = tire1Pressure;
    }

    public int getTire1Age() {
        return tire1Age;
    }

    public void setTire1Age(int tire1Age) {
        this.tire1Age = tire1Age;
    }

    public Double getTire2Pressure() {
        return tire2Pressure;
    }

    public void setTire2Pressure(Double tire2Pressure) {
        this.tire2Pressure = tire2Pressure;
    }

    public int getTire2Age() {
        return tire2Age;
    }

    public void setTire2Age(int tire2Age) {
        this.tire2Age = tire2Age;
    }

    public Double getTire3Pressure() {
        return tire3Pressure;
    }

    public void setTire3Pressure(Double tire3Pressure) {
        this.tire3Pressure = tire3Pressure;
    }

    public int getTire3Age() {
        return tire3Age;
    }

    public void setTire3Age(int tire3Age) {
        this.tire3Age = tire3Age;
    }

    public Double getTire4Pressure() {
        return tire4Pressure;
    }

    public void setTire4Pressure(Double tire4Pressure) {
        this.tire4Pressure = tire4Pressure;
    }

    public int getTire4Age() {
        return tire4Age;
    }

    public void setTire4Age(int tire4Age) {
        this.tire4Age = tire4Age;
    }
}
