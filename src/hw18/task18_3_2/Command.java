package hw18.task18_3_2;

public interface Command {
    void execute();
    void undo();
    Triangle.Memento getMemento();
}