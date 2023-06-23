package T4TrafficLights;

public class TrafficLights {
    private Lights lights;

    public TrafficLights(Lights lights) {
        this.lights = lights;
    }

    public Lights getLights() {
        return lights;
    }

    public void setLights(Lights lights) {
        this.lights = lights;
    }
    public Lights nextLight(){
        int a = this.lights.ordinal()+1;
        if (a>2){
            a=0;
        }
        this.lights = Lights.values()[a];
        return this.lights;
    }
}
