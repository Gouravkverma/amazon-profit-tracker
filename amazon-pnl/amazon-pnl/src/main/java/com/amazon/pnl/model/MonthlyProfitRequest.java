package com.amazon.pnl.model;

public class MonthlyProfitRequest {
    private int orderProfit;
    private double managementFee;
    private double storageFee;
    private double adFee;
    private double dollarRate;

    public int getOrderProfit() {
        return orderProfit;
    }

    public void setOrderProfit(int orderProfit) {
        this.orderProfit = orderProfit;
    }

    public double getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(double managementFee) {
        this.managementFee = managementFee;
    }

    public double getStorageFee() {
        return storageFee;
    }

    public void setStorageFee(double storageFee) {
        this.storageFee = storageFee;
    }

    public double getAdFee() {
        return adFee;
    }

    public void setAdFee(double adFee) {
        this.adFee = adFee;
    }

    public double getDollarRate() {
        return dollarRate;
    }

    public void setDollarRate(double dollarRate) {
        this.dollarRate = dollarRate;
    }
}