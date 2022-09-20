package Command;

public class GarageDoorOpenCommand implements Command {
    GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        GarageDoor door = new GarageDoor();
        door.up();
        door.stop();
        door.lightOn();
    }

    @Override
    public void undo() {

    }
}

