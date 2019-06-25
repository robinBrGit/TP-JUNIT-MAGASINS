package util;

import bo.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemDataset {

    public static Map<Item,Integer> itemMockup(){
        Map<Item,Integer> items = new HashMap<Item,Integer>();
        items.put(new Item("Stylo"),40);
        items.put(new Item("Feutre"),40);
        items.put(new Item("Ecran"),15);
        items.put(new Item("Ecouter"),20);
        items.put(new Item("Casque"),30);
        items.put(new Item("Montre"),5);
        items.put(new Item("Chaise"),10);

        return items;
    }
}
