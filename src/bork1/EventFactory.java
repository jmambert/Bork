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

/**
 *
 * @author Jordan
 */
public class EventFactory {

    private String noun;
    private String verb;

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
    public String execute() {
        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemFromInventoryNamed(noun);
            String thisHappens = s.findInLine("[");
            Scanner s = new Scanner(in).useDelimiter("\\s*[\\s*");
            Scanner sc = new Scanner(input).useDelimiter("\\s*]\\s*");

    /*int startIndex;
    startIndex = s.indexOf('[');
    System.out.println("indexOf([) = " + startIndex);
    int endIndex = s.indexOf(']');
    System.out.println("indexOf(]) = " + endIndex);
    System.out.println(s.substring(startIndex + 1, endIndex));
    */
        } catch (Item.NoItemException e) {
            return "Something went wrong in execute(), EventFactory";
        }

    }
}
