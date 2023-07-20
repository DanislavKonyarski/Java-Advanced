package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        for (Discoverer discoverer : discoverers) {
            while (discoverer.canDig() && spot.getExhibits().iterator().hasNext()){
                discoverer.dig();
                String exibit = spot.getExhibits().iterator().next();
                discoverer.getMuseum().getExhibits().add(exibit);
                spot.getExhibits().remove(exibit);
            }
        }
    }
}
