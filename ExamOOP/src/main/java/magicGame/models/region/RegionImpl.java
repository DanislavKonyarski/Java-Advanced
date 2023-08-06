package magicGame.models.region;

import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {

    @Override
    public String start(Collection<Magician> magicians) {
        int healthWizard = magicians.stream().filter(e -> e.getClass().getSimpleName().equals("Wizard"))
                .mapToInt(Magician::getHealth).sum();
        int healthBlackWidow = magicians.stream().filter(e -> e.getClass().getSimpleName().equals("BlackWidow"))
                .mapToInt(Magician::getHealth).sum();
        List<Magician> wizards = magicians.stream().filter(e->e.getClass().getSimpleName().equals("Wizard"))
                .collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream().filter(e->e.getClass().getSimpleName().equals("BlackWidow"))
                .collect(Collectors.toList());
        while (healthWizard>=0 || healthBlackWidow>=0){

            for (Magician wizard : wizards) {
                for (Magician blackWidow : blackWidows) {
                    if (blackWidow.isAlive()){
                        blackWidow.takeDamage(wizard.getMagic().fire());
                        break;
                    }
                }
            }
            for (Magician blackWidow : blackWidows) {
                for (Magician wizard : wizards) {
                    if (wizard.isAlive()){
                        wizard.takeDamage(blackWidow.getMagic().fire());
                        break;
                    }
                }
            }

            healthWizard = wizards.stream().filter(e -> e.getClass().getSimpleName().equals("Wizard"))
                    .mapToInt(Magician::getHealth).sum();
            healthBlackWidow = blackWidows.stream().filter(e -> e.getClass().getSimpleName().equals("BlackWidow"))
                    .mapToInt(Magician::getHealth).sum();
        }

            if (healthWizard<=0){
                return "Black widows win!";
            }else {
                return "Wizards win!";
            }
    }
}
