
package bork1;

/*
SaveCommand extends Command class
deals only with commands pertaining to saving the game
@author jmambert
*/
class SaveCommand extends Command {

    private static String DEFAULT_SAVE_FILENAME = "bork";

    private String saveFilename;

    /*
    SaveCommand is passed a @param string to save the users adventure
    @author jmambert
    */
    SaveCommand(String saveFilename) {
        if (saveFilename == null || saveFilename.length() == 0) {
            this.saveFilename = DEFAULT_SAVE_FILENAME;
        } else {
            this.saveFilename = saveFilename;
        }
    }

    /*
    execute() prints to the screen whether or not the file could be saved
    @author jmambert
    */
    public String execute() {
        try {
            GameState.instance().store(saveFilename);
            return "Data saved to " + saveFilename +
                GameState.SAVE_FILE_EXTENSION + ".\n";
        } catch (Exception e) {
            System.err.println("Couldn't save!");
            e.printStackTrace();
            return "";
        }
    }
}
