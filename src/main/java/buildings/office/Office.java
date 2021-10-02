package buildings.office;

import exceptions.InvalidRoomsCountException;
import exceptions.InvalidSpaceAreaException;
import interfaces.Space;

import java.io.Serializable;

public class Office implements Space, Serializable, Cloneable {
    private double square;
    private int rooms;
    private final double STANDART_SQUARE = 250.0;
    private final int STANDART_ROOMS = 1;

    public Office() {
        this.square = STANDART_SQUARE;
        this.rooms = STANDART_ROOMS;
    }

    public Office(double square) {
        if (square <= 0) throw new InvalidSpaceAreaException("Wrong square");
        this.square = square;
        this.rooms = STANDART_ROOMS;
    }

    public Office(double square, int rooms) {
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

    @Override
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("Office(").append(getRooms()).append(", ").append(getSquare()).append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Office)) return false;
        return (this.rooms == ((Office) o).getRooms() && this.square == ((Office) o).getSquare());
    }

    /*
        hash code using Bitwise exclusive OR of number of rooms and first four bytes of square and second four bytes of square
     */
    @Override
    public int hashCode() {
        String byteValue = Long.toBinaryString(Double.doubleToLongBits(square));
        return (rooms ^ Integer.parseInt(byteValue.substring(0, 31))) ^ Integer.parseInt(byteValue.substring(32));
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
