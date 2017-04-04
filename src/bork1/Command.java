
package bork1;

/*
Command is an abstract class that is the parent class to other classes that deal
    with multiple possible commands a user may input
@author jmambert
*/
abstract class Command {
/*
    constructor, but subclasses will override with their own execute() methods
    @author jmambert
    */
    abstract String execute();

}
