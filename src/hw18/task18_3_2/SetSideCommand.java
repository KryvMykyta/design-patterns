package hw18.task18_3_2;

public class SetSideCommand implements Command {
    private Triangle triangle;
    private String side;
    private float value;
    private Triangle.Memento memento;

    public SetSideCommand(Triangle triangle, String side, float value) {
        this.triangle = triangle;
        this.side = side;
        this.value = value;
        this.memento = triangle.createMemento();
    }

    @Override
    public void execute() {
        switch (side) {
            case "a":
                triangle.setA(value);
                break;
            case "b":
                triangle.setB(value);
                break;
            case "c":
                triangle.setC(value);
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