package bork1;

/*
Room @throws NoRoomException, reads through the file 
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;

public class Room {

    class NoRoomException extends Exception {
    }

    static String CONTENTS_STARTER = "Contents: ";

    private String title;
    private String desc;
    private boolean beenHere;
    public ArrayList<Item> contents;
    private ArrayList<Exit> exits;
    private boolean isDark;

    Room(String title) {
        init();
        this.title = title;
    }

    Room(Scanner s, Dungeon d) throws NoRoomException,
            Dungeon.IllegalDungeonFormatException {

        this(s, d, true);
    }

    /**
     * Given a Scanner object positioned at the beginning of a "room" file
     * entry, read and return a Room object representing it.
     *
     * @param d The containing {@link edu.umw.stephen.bork.Dungeon} object,
     * necessary to retrieve {@link edu.umw.stephen.bork.Item} objects.
     * @param initState should items listed for this room be added to it?
     * @throws NoRoomException The reader object is not positioned at the start
     * of a room entry. A side effect of this is the reader's cursor is now
     * positioned one line past where it was.
     * @throws IllegalDungeonFormatException A structural problem with the
     * dungeon file itself, detected when trying to read this room.
     * @author not jmambert
     */
    Room(Scanner s, Dungeon d, boolean initState) throws NoRoomException,
            Dungeon.IllegalDungeonFormatException {

        init();
        title = s.nextLine();
        desc = "";
        if (title.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoRoomException();
        }

        String lineOfDesc = s.nextLine();
        while (!lineOfDesc.equals(Dungeon.SECOND_LEVEL_DELIM)
                && !lineOfDesc.equals(Dungeon.TOP_LEVEL_DELIM)) {

            if (lineOfDesc.startsWith(CONTENTS_STARTER)) {
                String itemsList = lineOfDesc.substring(CONTENTS_STARTER.length());
                String[] itemNames = itemsList.split(",");
                for (String itemName : itemNames) {
                    try {
                        if (initState) {
                            add(d.getItem(itemName));
                        }
                    } catch (Item.NoItemException e) {
                        throw new Dungeon.IllegalDungeonFormatException(
                                "No such item '" + itemName + "'");
                    }
                }
            } else {
                desc += lineOfDesc + "\n";
            }
            lineOfDesc = s.nextLine();
        }

        // throw away delimiter
        if (!lineOfDesc.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            throw new Dungeon.IllegalDungeonFormatException("No '"
                    + Dungeon.SECOND_LEVEL_DELIM + "' after room.");
        }
    }

    // Common object initialization tasks.
    private void init() {
        contents = new ArrayList<Item>();
        exits = new ArrayList<Exit>();
        beenHere = false;
    }

    String getTitle() {
        return title;
    }

    void setDesc(String desc) {
        this.desc = desc;
    }

    /*
     * Store the current (changeable) state of this room to the writer
     * passed.
     */
    void storeState(PrintWriter w) throws IOException {
        w.println(title + ":");
        w.println("beenHere=" + beenHere);
        if (contents.size() > 0) {
            w.print(CONTENTS_STARTER);
            for (int i = 0; i < contents.size() - 1; i++) {
                w.print(contents.get(i).getPrimaryName() + ",");
            }
            w.println(contents.get(contents.size() - 1).getPrimaryName());
        }
        w.println(Dungeon.SECOND_LEVEL_DELIM);
    }

    void restoreState(Scanner s, Dungeon d) throws
            GameState.IllegalSaveFormatException {

        String line = s.nextLine();
        if (!line.startsWith("beenHere")) {
            throw new GameState.IllegalSaveFormatException("No beenHere.");
        }
        beenHere = Boolean.valueOf(line.substring(line.indexOf("=") + 1));

        line = s.nextLine();
        if (line.startsWith(CONTENTS_STARTER)) {
            String itemsList = line.substring(CONTENTS_STARTER.length());
            String[] itemNames = itemsList.split(",");
            for (String itemName : itemNames) {
                try {
                    add(d.getItem(itemName));
                } catch (Item.NoItemException e) {
                    throw new GameState.IllegalSaveFormatException(
                            "No such item '" + itemName + "'");
                }
            }
            s.nextLine();  // Consume "---".
        }
    }

    public String describe() {
        String description = "";
        if (isDark && GameState.instance().getIsLit() == false) { //if room dark
            return "Room is too dark to see, you are unable to explore.";
        } else //room is dark but they have light source
        if (beenHere && !GameState.instance().getVerboseState()) { //if been here is true, just print room name
            description = title;
            for (Item item : contents) { //print contents
                description += "\nThere is a " + item.getPrimaryName() + " here.";
            }
            if (contents.size() > 0) { //print contents
                description += "\n";
            }
        } else if (!beenHere && GameState.instance().getVerboseState()) {
            description = title + "\n" + desc; //print off desc, room name and contents
            for (Item item : contents) { //print contents
                description += "\nThere is a " + item.getPrimaryName() + " here.";
            }
            if (contents.size() > 0) { //print contents
                description += "\n";
            }
            for (Exit exit : exits) {
                description += "\n" + exit.describe();
            }
        } else if (beenHere && GameState.instance().getVerboseState()) { //if been here is true,  & verboseOFF, just print room name
            description = title;
            for (Item item : contents) { //print contents
                description += "\nThere is a " + item.getPrimaryName() + " here.";
            }
            if (contents.size() > 0) { //print contents
                description += "\n";
            }
            for (Exit exit : exits) {
                description += "\n" + exit.describe();
            }
        } else { //if havnt been here or verbose state is ture
            description = title + "\n" + desc; //print off desc, room name and contents
            for (Item item : contents) { //print contents
                description += "\nThere is a " + item.getPrimaryName() + " here.";
            }
            if (contents.size() > 0) { //print contents
                description += "\n";
            }
        }
        beenHere = true;
        return description;
    }

    public Room leaveBy(String dir) {
        for (Exit exit : exits) {
            if (exit.getDir().equals(dir)) {
                return exit.getDest();
            }
        }
        return null;
    }

    void addExit(Exit exit) {
        exits.add(exit);
    }
    
    Exit getExit(String exitName) {
        for(int i=0; i<exits.size();i++){
            if (exits.get(i).getDir().equals(exitName)){
                return exits.get(i);
            }
        }
        
        return null;
    }
    
    ArrayList<Exit> getExits() {
        return exits;
    }

    void add(Item item) {
        contents.add(item);
    }

    void remove(Item item) {
        contents.remove(item);
    }

    Item getItemNamed(String name) throws Item.NoItemException {
        for (Item item : contents) {
            if (item.goesBy(name)) {
                return item;
            }
        }
        throw new Item.NoItemException();
    }

    ArrayList<Item> getContents() {
        return contents;
    }

    
    
    public boolean getIsDark(){
        return isDark;
    }
    
    public void setIsDark(Boolean setLight){
        if(setLight == false) {
            isDark = true;
        }else{
            isDark = false;
        }
    }
    /*
    boolean isDark() {
        if (isDark == true) {
            return true; //lighted room
        } else {
            return false; //unlighted room
        }
    }
    */
}
