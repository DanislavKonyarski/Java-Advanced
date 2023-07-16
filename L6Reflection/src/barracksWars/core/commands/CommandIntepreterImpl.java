package barracksWars.core.commands;

import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandIntepreterImpl implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandIntepreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {

        String className = commandName.substring(0, 1).toUpperCase() + commandName.substring(1) + "Command";
        Executable command = null;
        try {
            Class clazz = Class.forName("barracksWars.core.commands." + className);
            Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            return constructor.newInstance(data, repository, unitFactory);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
