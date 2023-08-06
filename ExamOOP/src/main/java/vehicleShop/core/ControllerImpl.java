package vehicleShop.core;

import vehicleShop.models.shop.Shop;
import vehicleShop.models.shop.ShopImpl;
import vehicleShop.models.tool.ToolImpl;
import vehicleShop.models.vehicle.VehicleImpl;
import vehicleShop.models.worker.FirstShift;
import vehicleShop.models.worker.SecondShift;
import vehicleShop.models.worker.Worker;
import vehicleShop.repositories.VehicleRepository;
import vehicleShop.repositories.WorkerRepository;

import static vehicleShop.common.ConstantMessages.*;
import static vehicleShop.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private WorkerRepository workers;
    private VehicleRepository vehicles;

    public ControllerImpl() {
        this.workers = new WorkerRepository();
        this.vehicles = new VehicleRepository();
    }

    @Override
    public String addWorker(String type, String workerName) {
        if (!"FirstShift".equals(type)&&!"SecondShift".equals(type)){
            throw new IllegalArgumentException(WORKER_TYPE_DOESNT_EXIST);
        }
        if ("FirstShift".equals(type)){
            FirstShift firstShift = new FirstShift(workerName);
            workers.add(firstShift);
            return String.format(ADDED_WORKER,type,workerName);
        }else {
            SecondShift secondShift = new SecondShift(workerName);
            workers.add(secondShift);
            return String.format(ADDED_WORKER,type,workerName);
        }
    }

    @Override
    public String addVehicle(String vehicleName, int strengthRequired) {
        vehicles.add(new VehicleImpl(vehicleName,strengthRequired));
        return String.format(SUCCESSFULLY_ADDED_VEHICLE,vehicleName);
    }

    @Override
    public String addToolToWorker(String workerName, int power) {
        Worker worker = workers.findByName(workerName);
        if (worker==null){
            throw new IllegalArgumentException(HELPER_DOESNT_EXIST);
        }
        workers.findByName(workerName).addTool(new ToolImpl(power));
        return String.format(SUCCESSFULLY_ADDED_TOOL_TO_WORKER,power,workerName);
    }

    @Override
    public String makingVehicle(String vehicleName) {
        Shop shop = new ShopImpl();
        Worker worker = workers.getWorkers().stream()
                .filter(e-> e.getStrength()>70).findFirst().orElse(null);
        if (worker == null){
            throw new IllegalArgumentException(NO_WORKER_READY);
        }
        shop.make(vehicles.findByName(vehicleName),workers.getWorkers().stream()
                .filter(e-> e.getStrength()>70).findFirst().orElse(null));
        int count = (int) worker.getTools().stream().filter(e->e.getPower()==0).count();
        if (vehicles.findByName(vehicleName).reached()){
            return String.format(VEHICLE_DONE,vehicleName,"done")+String.format(COUNT_BROKEN_INSTRUMENTS,count);
        }else {
            return String.format(VEHICLE_DONE,vehicleName,"not done")+String.format(COUNT_BROKEN_INSTRUMENTS,count);
        }
    }

    @Override
    public String statistics() {
        int countMadeVehicle = (int) vehicles.getWorkers().stream().filter(e-> e.getStrengthRequired()==0).count();
        StringBuilder sb = new StringBuilder();
        sb.append(countMadeVehicle+" vehicles are ready!").append(System.lineSeparator());
        sb.append("Info for workers:").append(System.lineSeparator());
        for (Worker worker : workers.getWorkers() ) {
            sb.append(String.format("Name: %s, Strength: %s",worker.getName(),worker.getStrength())).append(System.lineSeparator());
            int countTools = (int) worker.getTools().stream().filter(e->e.getPower()>0).count();
            sb.append(String.format("Tools: %d fit left",countTools));
            sb.append(System.lineSeparator());
        }
        return String.valueOf(sb).trim();
    }
}
