package hw15.task15_3_2;

public class ShowInfoCommand implements Command {
    private Document document;

    public ShowInfoCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.showInfo();
    }
}