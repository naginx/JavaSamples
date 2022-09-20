package Command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("何もしない");
    }

    @Override
    public void undo() {
        System.out.println("何もしないけど戻す");
    }
}
