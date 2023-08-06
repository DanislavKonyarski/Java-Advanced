package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

public class ShopImpl implements Shop {
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        Tool tool = worker.getTools().stream().filter(e -> e.isUnfit()).findFirst().orElse(null);
        while (!vehicle.reached() && worker.canWork() && tool != null) {
            vehicle.making();
            worker.working();
            for (Tool t : worker.getTools() ) {
                if (t.isUnfit()){
                    t.decreasesPower();
                    break;
                }
            }
            tool = worker.getTools().stream().filter(e -> e.isUnfit()).findFirst().orElse(null);
        }
    }
}
