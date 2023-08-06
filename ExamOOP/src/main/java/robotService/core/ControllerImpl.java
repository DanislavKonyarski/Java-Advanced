package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        if (!type.equals("MainService") && !type.equals("SecondaryService")) {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        if (type.equals("MainService")) {
            MainService mainService = new MainService(name);
            this.services.add(mainService);
            return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
        } else {
            SecondaryService secondaryService = new SecondaryService(name);
            this.services.add(secondaryService);
            return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
        }
    }

    @Override
    public String addSupplement(String type) {
        if (!type.equals("PlasticArmor") && !type.equals("MetalArmor")) {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        if (type.equals("PlasticArmor")) {
            PlasticArmor plasticArmor = new PlasticArmor();
            this.supplements.addSupplement(plasticArmor);
            return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
        } else {
            MetalArmor metalArmor = new MetalArmor();
            this.supplements.addSupplement(metalArmor);
            return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
        }
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Service service = services.stream().filter(e -> e.getName().equals(serviceName)).findFirst().orElse(null);
        if (service == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        if (supplementType.equals("PlasticArmor")) {
            PlasticArmor plasticArmor = new PlasticArmor();
            service.addSupplement(plasticArmor);
            this.supplements.removeSupplement(plasticArmor);
        } else {
            MetalArmor metalArmor = new MetalArmor();
            service.addSupplement(metalArmor);
            this.supplements.removeSupplement(metalArmor);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        if (!robotType.equals("FemaleRobot") && !robotType.equals("MaleRobot")) {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        if ("FemaleRobot".equals(robotType)) {
            FemaleRobot femaleRobot = new FemaleRobot(robotName, robotKind, price);
            for (Service service : services) {
                if (service.getName().equals(serviceName)) {
                    if (service.getClass().getSimpleName().equals("SecondaryService")) {
                        service.addRobot(femaleRobot);
                        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
                    } else {
                        return UNSUITABLE_SERVICE;
                    }
                }
            }
        } else {
            MaleRobot maleRobot = new MaleRobot(robotName, robotKind, price);
            for (Service service : services) {
                if (service.getName().equals(serviceName)) {
                    if (service.getClass().getSimpleName().equals("MainService")) {
                        service.addRobot(maleRobot);
                        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
                    } else {
                        return UNSUITABLE_SERVICE;
                    }
                }
            }
        }
        return UNSUITABLE_SERVICE;
    }

    @Override
    public String feedingRobot(String serviceName) {
        int count = 0;
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                count = service.getRobots().size();
                service.feeding();
            }
        }
        return String.format(FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
        double sum = 0;
        for (Service service : services) {
            if (service.getName().equals(serviceName)) {
                for (Supplement supplement : service.getSupplements()) {
                    sum += supplement.getPrice();
                }
                for (Robot robot : service.getRobots()) {
                    sum += robot.getPrice();
                }
            }
        }
        return String.format(VALUE_SERVICE,serviceName,sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        services.forEach(e-> stringBuilder.append(e.getStatistics()).append(System.lineSeparator()));
        return String.valueOf(stringBuilder).trim();
    }
}
