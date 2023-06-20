package automotiveRepairShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RepairShop {

    private int capacity;
    List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        if (this.vehicles.size()<capacity){
            this.vehicles.add(vehicle);
        }
    }
    public boolean removeVehicle(String vin){
        for (int i = 0; i < this.vehicles.size(); i++) {
            if (this.vehicles.get(i).getVIN().equals(vin)){
                this.vehicles.remove(i);
                return true;
            }
        }
        return false;
    }
    public int getCount(){
        return this.vehicles.size();
    }
    public Vehicle getLowestMileage(){
        return this.vehicles.stream().sorted(Comparator.comparingInt(Vehicle::getMileage)).findFirst().orElse(null);
    }
    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vehicles in the preparatory:\n");
        this.vehicles.forEach(e-> stringBuilder.append(e+"\n"));
        return String.valueOf(stringBuilder);
    }
}
