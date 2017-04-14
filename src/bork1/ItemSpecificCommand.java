
package bork1;
/*
ItemSpecificCommand extends Command and deals with commands that are not already
    taken in account for
@author jmambert
*/

class ItemSpecificCommand extends Command {

    private String verb;
    private String noun;
                        

    /*
    Constructor with @param 2 strings called verb and noun
    sets them equal to variable
    @author jmambert
    */
    ItemSpecificCommand(String verb, String noun) {
        this.verb = verb;
        this.noun = noun;
    }

    /*
    overrides execute() method in command, tries to "verb" the "noun" but if not
        prints two possible error messages
    @author jmambert
    */
    public String execute() {
        
        Item itemReferredTo = null;
        try {
            itemReferredTo = GameState.instance().getItemInVicinityNamed(noun);
        } catch (Item.NoItemException e) {
            return "There's no " + noun + " here.\n";
        }
        
        String msg = itemReferredTo.getMessageForVerb(verb);
        return (msg == null ? 
            "Sorry, you can't " + verb + " the " + noun + "." : msg) + "\n";
    }
}
