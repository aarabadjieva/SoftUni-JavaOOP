package GreedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private long maxWeight;
    private long weight;
    private Item gold;
    private List<Item> gems;
    private List<Item> cash;
    private long amountOfGold;
    private long amountOfgems;
    private long amountOfCash;

    public Bag(long maxWeight) {
        this.maxWeight = maxWeight;
        this.weight = 0;
        this.gold = new Item("Gold",0);
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
        this.amountOfGold = -1;
        this.amountOfgems = 0;
        this.amountOfCash = 0;
    }

    public void setAmountOfGold(long amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public void setAmountOfgems(long amountOfgems) {
        this.amountOfgems = amountOfgems;
    }

    public void setAmountOfCash(long amountOfCash) {
        this.amountOfCash = amountOfCash;
    }

    public long getWeight() {
        return weight;
    }

    public Item getGold() {
        return gold;
    }

    public List<Item> getGems() {
        return gems;
    }

    public List<Item> getCash() {
        return cash;
    }

    public long getAmountOfGold() {
        return amountOfGold;
    }

    public long getAmountOfgems() {
        return amountOfgems;
    }

    public long getAmountOfCash() {
        return amountOfCash;
    }

    public long getMaxWeight() {
        return maxWeight;
    }

    public  void fillBag(String[] safeContent) {
        for (int i = 0; i < safeContent.length; i += 2) {
            String itemName = safeContent[i];
            long itemValue = Long.parseLong(safeContent[i + 1]);
            if (this.getWeight() + itemValue > this.getMaxWeight()) {
                return;
            }
            if (itemName.length() == 3) {
                Item item = new Item(itemName, itemValue);
                if (this.getAmountOfgems() >= this.getAmountOfCash() + itemValue) {
                    this.getCash().add(item);
                    this.setAmountOfCash(this.getAmountOfCash() + itemValue);
                }
            } else if (itemName.toLowerCase().endsWith("gem")) {
                Item item = new Item(itemName, itemValue);
                if (this.getGold().getValue() >= this.getAmountOfgems() + itemValue) {
                    this.getGems().add(item);
                    this.setAmountOfgems(this.getAmountOfgems() + itemValue);
                }
            } else if (itemName.toLowerCase().equals("gold")) {
                this.getGold().setValue(this.getGold().getValue() + itemValue);
                this.setAmountOfGold(this.getAmountOfGold() + itemValue);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.getAmountOfGold()!=0){
            result.append(String.format("<Gold> $%s%n",this.getGold().getValue()));
            result.append(this.getGold().toString());
        }
        if (this.getGems().size()>0){
            result.append(String.format("<Gem> $%s%n",this.getAmountOfgems()));
            this.getGems().sort(Comparator.comparing(Item::getName).reversed().thenComparing(Item::getValue));
            for (Item item:this.getGems()
            ) {
                result.append(item.toString());
            }
        }
        if (this.getCash().size()>0){
            result.append(String.format("<Cash> $%s%n",this.getAmountOfCash()));
            this.getCash().sort(Comparator.comparing(Item::getName).reversed().thenComparing(Item::getValue));
            for (Item item:this.getCash()
            ) {
                result.append(item.toString());
            }
        }
        return result.toString();
    }
}
