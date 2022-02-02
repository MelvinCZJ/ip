package Duke.Commands;

import Duke.DukeException.DukeException;
import Duke.System.Storage;
import Duke.System.TaskList;
import Duke.System.Ui;

public class CommandList extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ui.showList(tasks.tasksAsString());
    }
}