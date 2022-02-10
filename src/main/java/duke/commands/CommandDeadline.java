package duke.commands;

import duke.exceptions.DukeException;
import duke.system.Storage;
import duke.system.TaskList;
import duke.system.Ui;
import duke.tasks.Task;
import duke.tasks.TaskDeadline;
import duke.time.ManagerDate;
import duke.time.ManagerTime;

/**
 * The CommandDeadline class contains basic attributes and
 * behaviours of a Deadline Command.
 *
 * @author  Melvin Chan Zijun
 */
public class CommandDeadline extends Command {
    /**
     * Name of Task to be added
     */
    private final String name;

    /**
     * Date of Task to be added
     */
    private final String date;

    /**
     * Time of Task to be added
     */
    private final String time;

    /**
     * Sole constructor.
     *
     * @param name - name of Deadline Task to be created
     * @param date - date of Deadline Task to be created
     * @param time - time of Deadline Task to be created
     */
    public CommandDeadline(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    /**
     * Overrides method in parent class.
     * This method models the execution of a Deadline Command.
     * A Deadline Task gets created, the TaskList adds the task,
     * the Storage saves it and the Ui lets the user know
     * that the task was executed successfully.
     *
     * @param tasks - for TaskList to add Deadline Task
     * @param ui - to let user know that execution was successful
     * @param storage - to save updated TaskList
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ManagerDate md = new ManagerDate(date);
        ManagerTime mt = new ManagerTime(time);
        try {
            if (md.isDateValid() && mt.isTimeValid()) {
                Task task = new TaskDeadline(this.name, this.date, this.time);
                tasks.add(task);
                storage.save(tasks);
                return ui.showTaskAdded();
            } else{
                throw new DukeException("Invalid date and/or time!");
            }
        } catch (DukeException e) {
            return ui.showException(e);
        }
    }
}
