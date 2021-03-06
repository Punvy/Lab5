package com.punvy.base;

public class Coordinates {
    @MaxLongValue(max = 730)
	private long x; //Максимальное значение поля: 730
    private double y;

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinates(long x, double y) {
        this.x = x;
        this.y = y;
    }
}
