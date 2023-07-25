package football;

import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (!fieldType.equals("ArtificialTurf")&&!fieldType.equals("NaturalGrass")){
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        if (fieldType.equals("ArtificialTurf")){
            fields.add(new ArtificialTurf(fieldName));
        }else if (fieldType.equals("NaturalGrass")){
            fields.add(new NaturalGrass(fieldName));
        }
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE,fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if ("Liquid".equals(type)){
            supplement.add(new Liquid());
        } else if ("Powdered".equals(type)) {
            supplement.add(new Powdered());
        }else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE,type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        if("Liquid".equals(supplementType)){
            Supplement currentSupplement = new Liquid();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)){
                    field.addSupplement(currentSupplement);
                    return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType,fieldName);
                }
            }
        } else if ("Powdered".equals(supplementType)) {
            Supplement currentSupplement = new Powdered();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)){
                    field.addSupplement(currentSupplement);
                    return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType,fieldName);
                }
            }
        }
        throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        if (playerType.equals("Men")){
            Player player = new Men(playerName, nationality, strength);
            for (Field field : fields) {
                if (fieldName.equals(field.getName())){
                    if (field.getClass().getSimpleName().equals("NaturalGrass")){
                    field.addPlayer(player);
                    return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
                    }else {
                        return FIELD_NOT_SUITABLE;
                    }
                }
            }
        } else if (playerType.equals("Women")) {
            Player player = new Women(playerName, nationality, strength);
            for (Field field : fields) {
                if (fieldName.equals(field.getName())){
                    if (field.getClass().getSimpleName().equals("ArtificialTurf")){
                        field.addPlayer(player);
                        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType,fieldName);
                    }else {
                        return FIELD_NOT_SUITABLE;
                    }
                }
            }
        }else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        return null;
    }

    @Override
    public String dragPlayer(String fieldName) {
        int count = 0;
        for (Field field : fields) {
            if (field.getName().equals(fieldName)){
                field.drag();
               count = field.getPlayers().size();
            }
        }
        return String.format(PLAYER_DRAG,count);
    }

    @Override
    public String calculateStrength(String fieldName) {
        int sumStrenght = 0;
        for (Field field : fields) {
            for (Player player : field.getPlayers()) {
                sumStrenght += player.getStrength();
            }
        }
        return String.format(STRENGTH_FIELD,fieldName,sumStrenght);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

//        fields.forEach(e-> stringBuilder.append(e.getInfo()).append(System.lineSeparator()));
        for (Field field : this.fields) {
            stringBuilder.append(field.getInfo());
            stringBuilder.append(System.lineSeparator());
        }
        return String.valueOf(stringBuilder).trim();
    }
}
