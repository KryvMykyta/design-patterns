package hw16.task16_3_3;

import java.util.ArrayList;
import java.util.List;

public class Box implements Component {
    private final int id;
    private final List<Component> components = new ArrayList<>();

    public Box(int id) {
        this.id = id;
    }

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void execute() {
        System.out.println("Box{" + "id=" + id + "}");
        for (Component component : components) {
            component.execute();
        }
    }

    public List<Component> getComponents() {
        return components;
    }
}