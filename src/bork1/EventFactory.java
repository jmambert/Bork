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
public class EventFactory {

    private Item item;
    private String verb;

    EventFactory(Item noun, String verb) {
        this.item = noun;
        this.verb = verb;
    }

    //while (false) {
    //String tryThis = s.nextLine();
    //if (tryThis.contains(verb)) {

    //}
    
    public void parse() {

        String ee = item.getEventForVerb(verb);
        String ve[] = ee.split(",");
        String param = null;
        for (int i = 0; i < ve.length; i++) {
            if (ve[i].contains("(")) {
                param = ve[i].substring(ve[i].indexOf("(") + 1, ve[i].indexOf(")"));
            }
        
            String theEvent = ve[i];
        
            if (theEvent.contains("Win")) {
                new WinEvent().execute();
            }
            else if (theEvent.contains("Lose")) {
                new LoseEvent().execute();
            }
            else if (theEvent.contains("Teleport")) {
                new TeleportEvent().execute();
            }
            else if (theEvent.contains("Transform")) {
                String be[] = param.split(",");
                new TransformEvent(be[0],be[1]).execute();
            }
            else if (theEvent.contains("Die")) {
                new DieEvent().execute();
            }
            else if (theEvent.contains("Disappear")) {
                new DisappearEvent(param).execute();
            }
            else if (theEvent.contains("Wound")) {
                int num = Integer.valueOf(param);
                new WoundEvent(num).execute();
            }
            else if (theEvent.contains("Unlock")) {
                String be[] = param.split(",");
                new UnlockedEvent(be[0],be[1]).execute();
            }
            else if (theEvent.contains("Lock")) {
                String be[] = param.split(",");
                new LockedEvent(be[0],be[1]).execute();
            }
            else if (theEvent.contains("Light")) {
                new LightEvent().execute();
            }
            
        }
    }

}
