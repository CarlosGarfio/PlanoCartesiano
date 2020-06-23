package com.plancartesiano.model;

public class Punto2D {
    int x;
    int y;

    public Punto2D() {
        this.x = 0;
        this.y = 0;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
