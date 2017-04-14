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
class VerboseCommand extends Command {
    boolean verbose;
    
    VerboseCommand(String verb) {
        this.verbose = verbose;
        
    }
    
    public String execute() {
        /*if (verbose == "on") {
            
        }
        /*if(GameState.instance().getVerboseState() == true){
            GameState.instance().setVerboseState(false);
        }else{
            GameState.instance().setVerboseState(true);
        }
        String onOff = "";
        if(verbose == true) {
            onOff = "On";
        }else{
            onOff = "Off";
        } */
        return "Verbose mode is now .";
    }
    
}
