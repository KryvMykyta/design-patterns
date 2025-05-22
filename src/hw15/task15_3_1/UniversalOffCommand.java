package hw15.task15_3_1;

import java.util.List;

public class UniversalOffCommand implements Command {
    private List<Command> offCommands;

    public UniversalOffCommand(List<Command> offCommands) {
        this.offCommands = offCommands;
    }

    @Override
    public void execute() {
        for (Command command : offCommands) {
            command.execute();
        }
    }
}