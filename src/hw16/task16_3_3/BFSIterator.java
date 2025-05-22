package hw16.task16_3_3;

import java.util.LinkedList;
import java.util.Queue;

public class BFSIterator implements Iterator {
    private final Queue<Component> queue = new LinkedList<>();

    public BFSIterator(Box root) {
        if (root != null) {
            queue.offer(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Component next() {
        if (!hasNext()) {
            return null;
        }

        Component current = queue.poll();
        if (current instanceof Box) {
            Box box = (Box) current;
            queue.addAll(box.getComponents());
        }
        return current;
    }
}