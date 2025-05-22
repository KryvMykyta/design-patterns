package hw16.task16_3_3;

import java.util.Stack;

public class DFSIterator implements Iterator {
    private final Stack<Component> stack = new Stack<>();

    public DFSIterator(Box root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Component next() {
        if (!hasNext()) {
            return null;
        }

        Component current = stack.pop();
        if (current instanceof Box) {
            Box box = (Box) current;
            for (int i = box.getComponents().size() - 1; i >= 0; i--) {
                stack.push(box.getComponents().get(i));
            }
        }
        return current;
    }
}