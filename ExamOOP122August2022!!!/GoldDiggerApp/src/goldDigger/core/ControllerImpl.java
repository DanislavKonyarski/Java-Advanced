package goldDigger.core;

import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private int spotCount;

    public ControllerImpl() {
        discovererRepository = new DiscovererRepository();
        spotRepository = new SpotRepository();
        spotCount = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        boolean flag = false;
        switch (kind) {
            case "Anthropologist":
                discovererRepository.add(new Anthropologist(discovererName));
                flag = true;
                break;
            case "Archaeologist":
                discovererRepository.add(new Archaeologist(discovererName));
                flag = true;
                break;
            case "Geologist":
                discovererRepository.add(new Geologist(discovererName));
                flag = true;
                break;
            default:
                throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        }
        if (flag) {
            return String.format(DISCOVERER_ADDED, kind, discovererName);
        } else {
            return null;
        }
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }
        spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discovererRepository.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        } else {
            discovererRepository.remove(discovererRepository.byName(discovererName));
            return String.format(DISCOVERER_EXCLUDE, discovererName);
        }
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> discoverersWithEnergy = discovererRepository.getCollection().
                stream().filter(e -> e.getEnergy() > 45).collect(Collectors.toList());
        if (discoverersWithEnergy.isEmpty()){
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Spot spot = spotRepository.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot,discoverersWithEnergy);
        long tiredDiscoverers = discoverersWithEnergy.stream().filter(d -> d.getEnergy()==0).count();
        this.spotCount++;
        return String.format(INSPECT_SPOT,spotName,tiredDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT,spotCount)).append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        Collection<Discoverer> discoverers = discovererRepository.getCollection();
        for (Discoverer discoverer : discoverers) {
            sb.append(String.format(FINAL_DISCOVERER_NAME,discoverer.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_DISCOVERER_ENERGY,discoverer.getEnergy())).append(System.lineSeparator());
            Collection<String> discoverExhibits = discoverer.getMuseum().getExhibits();
            if (discoverExhibits.isEmpty()){
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,"None")).append(System.lineSeparator());
            }else {
                String allMuseumExhibitsText = String.join(FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER,discoverExhibits);
                sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS,allMuseumExhibitsText)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
