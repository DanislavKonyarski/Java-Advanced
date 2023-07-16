package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class RetireCommand extends Command{
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }
    @Override
    public  String execute() {
        try {
            getRepository().removeUnit(getData()[1]);
            return String.format("%s retired!",getData()[1]);
        }catch (IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
