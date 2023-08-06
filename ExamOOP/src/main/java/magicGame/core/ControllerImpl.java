package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.MagicImpl;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.*;

public class ControllerImpl implements Controller{

//    •	magics - MagicRepositoryImpl
//•	magicians – MagicianRepositoryImpl
//•	region - Region

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        if (type.equals("RedMagic")){
            this.magics.addMagic(new RedMagic(name,bulletsCount));
            return String.format(SUCCESSFULLY_ADDED_MAGIC,name);
        } else if (type.equals("BlackMagic")) {
            this.magics.addMagic(new BlackMagic(name,bulletsCount));
            return String.format(SUCCESSFULLY_ADDED_MAGIC,name);
        }
        throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE) ;
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magic magic = magics.getData().stream().filter(e-> e.getName().equals(magicName)).findFirst().orElse(null);
        if (magic == null){
            throw new IllegalArgumentException(MAGIC_CANNOT_BE_FOUND);
        }
        if (type.equals("Wizard")){
            Wizard wizard = new Wizard(username,health,protection,magic);
            magicians.addMagician(wizard);
            return String.format(SUCCESSFULLY_ADDED_MAGICIAN,username);
        } else if (type.equals("BlackWidow")) {
            BlackWidow blackWidow = new BlackWidow(username,health,protection,magic);
            magicians.addMagician(blackWidow);
            return String.format(SUCCESSFULLY_ADDED_MAGICIAN,username);
        }
        throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        List<Magician> magicianList = magicians.getData().stream().sorted(Comparator.comparing(Magician::getHealth)
                .thenComparing(Magician::getUsername)
                .thenComparing(Comparator.comparing(e -> e.getClass().getSimpleName()))).collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (Magician magician : magicianList) {
            stringBuilder.append(String.format(magician.toString()));
        }
        return String.valueOf(stringBuilder).trim();
    }
}
