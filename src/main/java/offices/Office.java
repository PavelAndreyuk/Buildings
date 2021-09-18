package offices;

import interfaces.Space;

public class Office implements Space {
    private double square;
    private int rooms;
    private final double STANDART_SQUARE = 250.0;
    private final int STANDART_ROOMS = 1;

    public Office() {
        this.square = STANDART_SQUARE;
        this.rooms = STANDART_ROOMS;
    }

    public Office(double square) {
        this.square = square;
        this.rooms = STANDART_ROOMS;
    }

    public Office(double square, int rooms) {
        this.square = square;
        this.rooms = rooms;
    }


    @Override
    public int getRooms() {
        return this.rooms;
    }

    @Override
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public double getSquare() {
        return this.square;
    }

    @Override
    public void setSquare(double square) {
        this.square = square;
    }
}
