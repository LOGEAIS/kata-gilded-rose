package com.gildedrose;

class GildedRose {


    public static final String CONCERT_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    /*
     /!\ Do not change code above this line /!\
     */

    public void updateQuality() {
        for (Item item : items) {
            item.updateStrategy();
        }
    }
}
