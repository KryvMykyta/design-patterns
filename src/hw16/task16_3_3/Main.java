package hw16.task16_3_3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final Box root = new Box(-999);

        for (int j = 0; j < 10; j++) {
            final Box box = new Box(j);
            root.add(box);
            for (int i = 0; i < 10; i++) {
                String name = String.format("Item_%s", j * 10 + i);
                int value = random.nextInt(1000);
                final Item item = new Item(name, value);
                box.add(item);
            }
        }

        System.out.println("Original Tree Execution:");
        root.execute();

        System.out.println("\nUsing DFS Iterator:");
        findCheapestAndMostExpensive(new DFSIterator(root));

        System.out.println("\nUsing BFS Iterator:");
        findCheapestAndMostExpensive(new BFSIterator(root));
    }

    private static void findCheapestAndMostExpensive(Iterator iterator) {
        Item cheapest = null;
        Item mostExpensive = null;
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        while (iterator.hasNext()) {
            Component component = iterator.next();
            if (component instanceof Item) {
                Item item = (Item) component;
                int value = item.toString().contains("value=") ?
                        Integer.parseInt(item.toString().split("value=")[1].replace("}", "")) : 0;
                if (value < minValue) {
                    minValue = value;
                    cheapest = item;
                }
                if (value > maxValue) {
                    maxValue = value;
                    mostExpensive = item;
                }
            }
        }

        System.out.println("Cheapest Item: " + (cheapest != null ? cheapest : "None"));
        System.out.println("Most Expensive Item: " + (mostExpensive != null ? mostExpensive : "None"));
    }
}