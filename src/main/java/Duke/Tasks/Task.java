package Duke.Tasks;

public abstract class Task {
    private final String name;
    // task state: true = done, false = not done
    private boolean state;

    Task(String name) {
        this.name = name;
        this.state = false;
    }

    public abstract String getPrefix();
    public abstract String getDate();
    public abstract String getTime();

    public void mark() {
        this.state = true;
    }

    public void unmark() {
        this.state = false;
    }

    public boolean isMarked() {
        return this.state;
    }

    public boolean isEmptyTask() {
        return false;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String box = "";
        if (this.state)
            box += "[X] ";
        else
            box += "[ ] ";
        return box + this.name;
    }

}