package hw16.task16_3_2;

import java.util.HashMap;
import java.util.Iterator;

public class Shop implements Iterable<ShopItem> {

    private final HashMap<String, ShopItem> items = new HashMap<>();

    public void putItem(ShopItem item) {
        items.put(item.getName(), item);
    }

    @Override
    public Iterator<ShopItem> iterator() {
        return new ShopItemIterator(items, OrderType.ALPHABETICAL);
    }

    public Iterator<ShopItem> iteratorByQuantity() {
        return new ShopItemIterator(items, OrderType.QUANTITY_DESC);
    }

    public enum OrderType {
        ALPHABETICAL,
        QUANTITY_DESC
    }
}