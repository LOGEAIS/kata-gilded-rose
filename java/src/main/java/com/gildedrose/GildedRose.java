package com.gildedrose;

class GildedRose {


    private static final String CONCERT_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
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

            if (isNotEqualToAgedBrieAndConcertPasses(item)) {
                descreaseQualityIfNotSulfuras(item);
            } else {
                increaseQuality(item);
            }

            if (!isNameEquals(item.getName(), SULFURAS)) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                isDifferentToAgedBrie(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
            if (isNameEquals(item.getName(), CONCERT_PASSES)) {
                if (item.getSellIn() < 11) isLessToMaxQuality(item);
                if (item.getSellIn() < 6) isLessToMaxQuality(item);
            }
        }
    }

    private boolean isNotEqualToAgedBrieAndConcertPasses(Item item) {
        return !isNameEquals(item.getName(), AGED_BRIE) && !isNameEquals(item.getName(), CONCERT_PASSES);
    }

    private void isDifferentToAgedBrie(Item item) {
        if (!isNameEquals(item.getName(), AGED_BRIE)) {
            isDiffirentToConcertPasses(item);
        } else {
            isLessToMaxQuality(item);
        }
    }

    private void isDiffirentToConcertPasses(Item item) {
        if (!isNameEquals(item.getName(), CONCERT_PASSES)) {
            descreaseQualityIfNotSulfuras(item);
        } else {
            item.setQuality(0);
        }
    }

    private void descreaseQualityIfNotSulfuras(Item item) {
        if (item.getQuality() > 0 && !isNameEquals(item.getName(), SULFURAS)) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void isLessToMaxQuality(Item item) {
        if (item.getQuality() < MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private boolean isNameEquals(String itemName, String expectedName){
        return itemName.equals(expectedName);
    }
}
