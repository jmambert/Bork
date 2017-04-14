/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * when event is triggered, player's current room is set to a random different room
 */
import java.util.Hashtable;
import java.util.Random;
import java.util.Collection;

class TeleportEvent extends Event {

    TeleportEvent() {

    }
/**
 * 
 * @author jmambert
 * sets a random room as adventurers current room and returns a string
 */
    public String execute() {
        Room currentRoom = GameState.instance().getAdventurersCurrentRoom();
        Hashtable possibleRooms = GameState.instance().getDungeon().getHashtableRooms();
        Collection possibleCRooms = possibleRooms.values();
        Room[] possibleARooms = (Room[]) possibleCRooms.toArray(new Room[0]);
        //Object[] possibleARooms = possibleCRooms.toArray();
        Random rand = new Random(); //generates random number
        int n = rand.nextInt(possibleARooms.length - 1); //number range between 0-max in array
        Room position = possibleARooms[n]; //get room at position
        while (position == currentRoom) { //if the position equals the room player is already in,
            n = rand.nextInt(possibleARooms.length - 1); //generate range between 0-max in array
            position = possibleARooms[n]; //get room at that position
        }
        GameState.instance().setAdventurersCurrentRoom(position);
        return "Whoa! You are now in " + position + "!";
    }

}
