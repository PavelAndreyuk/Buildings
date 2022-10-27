package buildings.dwelling;

import exceptions.InvalidRoomsCountException;
import exceptions.InvalidSpaceAreaException;
import interfaces.Space;

import java.io.Serializable;

public class Flat implements Space, Serializable {
    private static final double STANDARD_SQUARE = 50.0;
    private static final int STANDARD_ROOMS = 2;

    private double square;
    private int rooms;

    public Flat() {
        this.square = STANDARD_SQUARE;
        this.rooms = STANDARD_ROOMS;
    }

    public Flat(double square) {
        if (square <= 0) throw new InvalidSpaceAreaException("Wrong square");

        this.square = square;
        this.rooms = STANDARD_ROOMS;
    }

    public Flat(double square, int rooms) {
        if (square <= 0) throw new InvalidSpaceAreaException("Wrong square");
        if (rooms < 0) throw new InvalidRoomsCountException("Wrong number of rooms");

        this.square = square;
        this.rooms = rooms;
    }

    @Override
    public int getRooms() {
        return this.rooms;
    }

    @Override
    public void setRooms(int rooms) {
        if (rooms < 0) throw new InvalidRoomsCountException("Wrong number of rooms");

        this.rooms = rooms;
    }

    @Override
    public double getSquare() {
        return this.square;
    }

    @Override
    public void setSquare(double square) {
        if (rooms <= 0) throw new InvalidSpaceAreaException("Wrong square");

        this.square = square;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer
                .append("Flat(")
                .append(getRooms())
                .append(", ")
                .append(getSquare())
                .append(")");

        return stringBuffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {return true;}
        if (!(o instanceof Flat)) {return false;}
        return (this.rooms == ((Flat) o).getRooms() && this.square == ((Flat) o).getSquare());
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Space o) {
        if (this.square == o.getSquare()) return 0;
        return this.square - o.getSquare() > 0 ? -1 : 1;
    }
}
