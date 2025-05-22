package hw16.task16_3_2;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ShopItem pens = new ShopItem("pen", 175);
        ShopItem pencils = new ShopItem("pencil", 0);
        ShopItem paper = new ShopItem("paper", 500);

        Shop shop = new Shop();
        shop.putItem(pens);
        shop.putItem(pencils);
        shop.putItem(paper);

        System.out.println("Items in alphabetical order:");
        for (ShopItem item : shop) {
            System.out.println(item);
        }

        System.out.println("\nItems in descending quantity order:");
        for (Iterator<ShopItem> it = shop.iteratorByQuantity(); it.hasNext(); ) {
            ShopItem item = it.next();
            System.out.println(item);
        }
    }
}