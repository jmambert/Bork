/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan, Leonard
 */
class VerboseCommand extends Command {
    String verbose;
    
    VerboseCommand(String verb) {
        this.verbose = verb;
        
    }
    
    public String execute() {
        if(verbose.toLowerCase().equals("on")){
            GameState.instance().setVerboseState(true);
            return "Verbose mode is on";
        }
        if(verbose.toLowerCase().equals("off")){
            GameState.instance().setVerboseState(false);
            return "Verbose mode is off";
        }
        else{
            return "Bad use of verbose mode";
        }
    }
    
}
