package hw18.task18_3_2;

public class HalveSideCommand implements Command {
    private Triangle triangle;
    private String side;
    private Triangle.Memento memento;

    public HalveSideCommand(Triangle triangle, String side) {
        this.triangle = triangle;
        this.side = side;
        this.memento = triangle.createMemento();
    }

    @Override
    public void execute() {
        switch (side) {
            case "a":
                triangle.halveSideA();
                break;
            case "b":
                triangle.halveSideB();
                break;
            case "c":
                triangle.halveSideC();
                break;
        }
    }

    @Override
    public void undo() {
        triangle.restoreMemento(memento);
    }

    @Override
    public Triangle.Memento getMemento() {
        return triangle.createMemento();
    }
}