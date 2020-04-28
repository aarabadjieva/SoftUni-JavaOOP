package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ComandInterpretatorImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "pr0304Barracks.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public ComandInterpretatorImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Executable interpretCommand(String[] data) {
        String commandName = Character.toUpperCase(data[0].charAt(0))+data[0].substring(1);
        Executable executable = null;
        try {
            Class<? extends Executable > commandClass = (Class<? extends Executable>)
                    Class.forName(COMMANDS_PACKAGE_NAME + commandName);
            Constructor constructor = commandClass.getDeclaredConstructor(String[].class);
          executable = (Executable) constructor.newInstance(new Object[]{data});

          Field[] executableFields = executable.getClass().getDeclaredFields();
          Field[] thisCommandImpl = this.getClass().getDeclaredFields();
            for (Field exField:executableFields
                 ) {
                if (exField.isAnnotationPresent(Inject.class)){
                    for (Field field:thisCommandImpl
                         ) {
                        if (exField.getType().equals(field.getType())){
                            exField.setAccessible(true);
                            exField.set(executable, field.get(this));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return executable;
    }
}
