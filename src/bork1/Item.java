
package bork1;

/*
Item class creates a hashtable to hold all of the messages for each item in the dungeon
@throws NoItemException
@author jmambert
*/
import java.util.Scanner;
import java.util.Hashtable;

public class Item {
    
    static class NoItemException extends Exception {}

    private String primaryName;
    private int weight;
    private Hashtable<String,String> messages;
    private Hashtable<String,String>events;


    Item(Scanner s) throws NoItemException,
        Dungeon.IllegalDungeonFormatException {

        messages = new Hashtable<String,String>();
        events = new Hashtable<String,String>();

        // Read item name.
        primaryName = s.nextLine();
        if (primaryName.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoItemException();
        }

        // Read item weight.
        weight = Integer.valueOf(s.nextLine());

        // Read and parse verbs lines, as long as there are more.
        String verbLine = s.nextLine();
        while (!verbLine.equals(Dungeon.SECOND_LEVEL_DELIM)) {
            if (verbLine.equals(Dungeon.TOP_LEVEL_DELIM)) {
                throw new Dungeon.IllegalDungeonFormatException("No '" +
                    Dungeon.SECOND_LEVEL_DELIM + "' after item.");
            }
            String[] verbParts = verbLine.split(":");
            if(verbParts[0].contains("[")) {
            messages.put(verbParts[0].substring(0,verbParts[0].indexOf("[")),verbParts[1]); //recycle and booya
            events.put(verbParts[0].substring(0,verbParts[0].indexOf("[")), //recycle
                    verbParts[0].substring(verbParts[0].indexOf("[")+1,
                            verbParts[0].indexOf("]"))); //
            }
            else {
                messages.put(verbParts[0],verbParts[1]);
            }
            
            verbLine = s.nextLine();
        }
    }

    /*
    Has an @param of a string called name
    returns the primary name of the string it is passed
    @author jmambert
    */
    boolean goesBy(String name) {
        // could have other aliases
        return this.primaryName.equals(name);
    }

    /*
    returns the primaryName
    @author jmambert
    */
    String getPrimaryName() { 
        return primaryName; 
    }

    /*
    getMessageForVerb @param string called verb
    gets the accompanying message for the verb the user entered
    returns message
    @author jmambert
    */
    public String getMessageForVerb(String verb) {
        return messages.get(verb);
    }
    
    public String getEventForVerb(String event) {
        return events.get(event);
    }

    /*
    toString returns the primaryName of an item when called upon
    @author jmambert
    */
    public String toString() {
        return primaryName;
    }
}
