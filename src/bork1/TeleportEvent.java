/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 */
import java.util.Hashtable;
import java.util.Random;
import java.util.Collection;

class TeleportEvent extends Event {

    private Hashtable Rooms;

    TeleportEvent() {
        this.Rooms = Rooms;

    }

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
            n = rand.nextInt(possibleRooms.size()); //generate new number
            n = rand.nextInt(possibleARooms.length - 1); //number range between 0-max in array
            position = possibleARooms[n]; //get room at that position
        }
        GameState.instance().setAdventurersCurrentRoom(position);
        return "";
    }

}
