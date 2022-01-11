/* Do not touch this file */

package com.gildedrose;

public class Item implements ItemInterface{

    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public void updateStrategy() {
        if (this.getQuality() > 0 ) {
            this.setQuality(this.getQuality() - 1);
        }

        this.setSellIn(this.getSellIn() - 1);

        if (this.getSellIn() < 0) {
            if (this.getQuality() > 0) {
                this.setQuality(this.getQuality() - 1);
            }
        }
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
