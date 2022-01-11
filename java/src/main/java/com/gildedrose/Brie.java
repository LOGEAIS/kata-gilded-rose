package com.gildedrose;

public class Brie extends Item implements ItemInterface{

    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateStrategy() {
        if (this.getQuality() < GildedRose.MAX_QUALITY) {
            this.setQuality(this.getQuality() + 1);
        }
        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            if (this.getQuality() < GildedRose.MAX_QUALITY) {
                this.setQuality(this.getQuality() + 1);
            }
        }
    }
}
