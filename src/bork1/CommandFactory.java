
package bork1;

import java.util.List;
import java.util.Arrays;

public class CommandFactory {

    private static CommandFactory theInstance;
    public static List<String> MOVEMENT_COMMANDS = 
        Arrays.asList("n","w","e","s","u","d" );

    public static synchronized CommandFactory instance() {
        if (theInstance == null) {
            theInstance = new CommandFactory();
        }
        return theInstance;
    }

    private CommandFactory() {
    }

    public Command parse(String command) {
        String parts[] = command.split(" ");
        String verb = parts[0];
        String noun = parts.length >= 2 ? parts[1] : "";
        if (verb.toLowerCase().equals("save")) {
            return new SaveCommand(noun);
        }
        else if (verb.toLowerCase().equals("take")) {
            return new TakeCommand(noun);
        }
        else if (verb.toLowerCase().equals("drop")) {
            return new DropCommand(noun);
        }
        else if (verb.toLowerCase().equals("i") || verb.equals("inventory")) {
            return new InventoryCommand();
        }
        else if (MOVEMENT_COMMANDS.contains(verb)) {
            return new MovementCommand(verb);
        }
        else if (parts.length == 2) {
            return new ItemSpecificCommand(verb, noun);
        }
        else if (verb.toLowerCase().equals("score")) {
            return new ScoreCommand();
        }
        else if (verb.toLowerCase().equals("health")) {
            return new HealthCommand();
        }
        else if (verb.toLowerCase().equals("on")) {
            return new VerboseCommand();
        }
        return new UnknownCommand(command);
    }
}
