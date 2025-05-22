package hw18.task18_3_2;

public class DoubleSideCommand implements Command {
    private Triangle triangle;
    private String side;
    private Triangle.Memento memento;

    public DoubleSideCommand(Triangle triangle, String side) {
        this.triangle = triangle;
        this.side = side;
        this.memento = triangle.createMemento();
    }

    @Override
    public void execute() {
        switch (side) {
            case "a":
                triangle.doubleSideA();
                break;
            case "b":
                triangle.doubleSideB();
                break;
            case "c":
                triangle.doubleSideC();
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