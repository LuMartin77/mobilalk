package com.example.pcwebshop;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    public static List<Item> getItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item(
                "1",
                "Gaming Egér",
                "Ergonomikus gamer egér",
                9990,
                10,
                "eger", // drawable mappában lévő fájlnév (kiterjesztés nélkül!)
                "Egér",
                "RGB, 8000 DPI, USB"
        ));

        items.add(new Item(
                "2",
                "Billentyűzet",
                "Mechanikus, világítós",
                14990,
                5,
                "keyboard",
                "Outemu blue switch, magyar kiosztás",
                "egy két há"
        ));

        return items;
    }
}

