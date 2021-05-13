package com.oliwasi.cryptotracker.data;

public class CurrencyPair {
    private int id;
    private Currency primary;
    private Currency secondary;
    private double lastPrice;
    private double lowestAsk;
    private double highestBid;
    private double percentChange;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Currency getPrimary() {
        return primary;
    }

    public void setPrimary(Currency primary) {
        this.primary = primary;
    }

    public Currency getSecondary() {
        return secondary;
    }

    public void setSecondary(Currency secondary) {
        this.secondary = secondary;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(double lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }
}
