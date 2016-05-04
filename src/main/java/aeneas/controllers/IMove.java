package aeneas.controllers;

/**
 * Interface representing a single move action to be completed
 * @author Logan
 * @author jbkuszmaul
 * @author Peter Mitrano
 */
public interface IMove {

    /**
     * Executes the move action
     * @return returns true if the move is successfully completed
     */
    public boolean execute();

    /**
     * Undoes this move action
     * @return returns true if the move action was successfully undone
     */
    public boolean undo();

    /**
     * Checks if the move action is a valid action
     * @return whether the move action is a valid action
     */
    public boolean isValid();
}
