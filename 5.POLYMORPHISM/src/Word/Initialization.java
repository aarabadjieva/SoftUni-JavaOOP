package Word;

public class Initialization {

    public static CommandInterface buildCommandInterface(StringBuilder text) {
       CommandImpl command = new AdvancedCommands(text);
       command.init();
       return command;
    }
}
