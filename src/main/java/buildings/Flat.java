package buildings;

import exceptions.InvalidRoomsCountException;
import exceptions.InvalidSpaceAreaException;
import interfaces.Space;

import java.io.Serializable;

public class Flat implements Space, Serializable {
    private double square;
    private int rooms;
    private final double STANDART_SQUARE = 50.0;
    private final int STANDART_ROOMS = 2;

    public Flat() {
        this.square = STANDART_SQUARE;
        this.rooms = STANDART_ROOMS;
    }

    public Flat(double square) {
        if (square <= 0) throw new InvalidSpaceAreaException("Wrong square");
        this.square = square;
        this.rooms = STANDART_ROOMS;
    }

    public Flat(double square, int rooms) {
        if (square <= 0) throw new InvalidSpaceAreaException("Wrong square");
        if (rooms <= 0) throw new InvalidRoomsCountException("Wrong number of rooms");
        this.square = square;
        this.rooms = rooms;
    }


    @Override
    public int getRooms() {
        return this.rooms;
    }

    @Override
    public void setRooms(int rooms) {
        if (rooms <= 0) throw new InvalidRoomsCountException("Wrong number of rooms");
        this.rooms = rooms;
    }

    @Override
    public double getSquare() {
        return this.square;
    }

    @Override
    public void setSquare(double square) {
        if (rooms<=0) throw new InvalidSpaceAreaException("Wrong square");
        this.square = square;
    }
}
