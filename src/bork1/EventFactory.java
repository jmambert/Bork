/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Jordan
 */
public class EventFactory {

    private String noun;
    private String verb;
    private Dungeon d;
    private Scanner c;

    EventFactory (Scanner c, Dungeon d) {
        this.c = c;
        this.d = d;
    }
    EventFactory(String noun, String verb) {
        this.noun = noun;
        this.verb = verb;
    }

    ArrayList<Item> contents = new ArrayList<>();

    Scanner s = new Scanner(System.in);
    private boolean found = false;
    //while (false) {
    //String tryThis = s.nextLine();
    //if (tryThis.contains(verb)) {

    //}
    public Event parse() {
        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemFromInventoryNamed(noun);
            String thisHappens = s.findInLine("[");
            try {
                String filename = null;
            Scanner read = new Scanner (new FileReader(filename));
            read.useDelimiter("[");
            read.useDelimiter("]");
            } catch (FileNotFoundException e) {
                
            }
            String theEvent = s.next();
            if (theEvent.equals("win")) {
                return new WinEvent();
            }
            else if (theEvent.equals("lose")) {
                return new LoseEvent();
            }
            else if (theEvent.equals("teleport")) {
                return new TeleportEvent();
            }
            else if (theEvent.equals("transform")) {
                return new TransformEvent();
            }
            else if (theEvent.equals("die")) {
                return new DieEvent();
            }
            else if (theEvent.equals("disappear")) {
                return new DisappearEvent();
            }
            else if (theEvent.equals("wound")) {
                return new WoundEvent();
            }
            else if (theEvent.equals("unlock")) {
                return new UnlockedEvent();
            }
           
            return NoEvent();
            
        } catch (Item.NoItemException e) {
            
        }
        return null;
    }

    private Event NoEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
