package duke.commands;

import duke.system.Storage;
import duke.system.TaskList;
import duke.system.Ui;

/**
 * The CommandExit class contains the basic
 * behaviours of a Exit Command.
 *
 * @author  Melvin Chan Zijun
 */
public class CommandExit extends Command {
    /**
     * Overrides method in parent class.
     * This method models the execution of an Exit Command.
     * The Ui prints the Exit message.
     *
     * @param tasks - not used
     * @param ui - to print all the tasks
     * @param storage - not used
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        return ui.showExit();
    }

    /**
     * Overrides method in parent class.
     * This method always returns true since it is
     * an Exit Command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
