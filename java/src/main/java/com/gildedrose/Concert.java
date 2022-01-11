package com.gildedrose;

public class Concert extends Item implements ItemInterface{

    public Concert(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateStrategy() {
        if (this.getQuality() < GildedRose.MAX_QUALITY) {
            this.setQuality(this.getQuality() + 1);
                if (this.getSellIn() < 11 && this.getQuality() < GildedRose.MAX_QUALITY) {
                    this.setQuality(this.getQuality() + 1);
                }
                if (this.getSellIn() < 6 && this.getQuality() < GildedRose.MAX_QUALITY) {
                    this.setQuality(this.getQuality() + 1);
                }
        }
        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            this.setQuality(0);
        }
    }
}
