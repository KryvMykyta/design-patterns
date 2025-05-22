package hw16.task16_3_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ShopItemIterator implements Iterator<ShopItem> {

    private final List<ShopItem> sortedItems;
    private int currentIndex = 0;

    public ShopItemIterator(HashMap<String, ShopItem> items, Shop.OrderType orderType) {
        this.sortedItems = new ArrayList<>(items.values());

        if (orderType == Shop.OrderType.ALPHABETICAL) {
            this.sortedItems.sort(Comparator.comparing(ShopItem::getName));
        } else if (orderType == Shop.OrderType.QUANTITY_DESC) {
            this.sortedItems.sort((item1, item2) -> Integer.compare(item2.getQuantity(), item1.getQuantity()));
        }
    }

    @Override
    public boolean hasNext() {
        return currentIndex < sortedItems.size();
    }

    @Override
    public ShopItem next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements to iterate");
        }
        return sortedItems.get(currentIndex++);
    }
}