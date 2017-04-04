
package bork1;

/*
UnknownCommand extends Command and deals with commands that are not necessarily
    understood by the system from the user
@author jmambert
*/
class UnknownCommand extends Command {

    private String bogusCommand;

    /*
    Constructor is passed a @param string that is sset equal to bogusCommand
    @author jmambert
    */
    UnknownCommand(String bogusCommand) {
        this.bogusCommand = bogusCommand;
    }

    /*
    execute() prints string to screen to let user know that command was not
        understood
    @author jmambert
    */
    String execute() {
        return "I'm not sure what you mean by \"" + bogusCommand + "\".\n";
    }
}
