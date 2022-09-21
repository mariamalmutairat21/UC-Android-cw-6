package com.example.mys;

public class ItemsG {

    private String gameName;
    private double gamePrice;
    private int gameImg;

    public ItemsG(String gameName, double gamePrice, int gameImg) {
        this.gameName = gameName;
        this.gamePrice = gamePrice;
        this.gameImg = gameImg;
    }

    public static void gameName() {
    }

    public static int gameImg() {
        return 0;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public int getGameImg() {
        return gameImg;
    }

    public void setGameImg(int gameImg) {
        this.gameImg = gameImg;
    }
}
