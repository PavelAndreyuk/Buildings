package buildings;

public class Flat {
    private double square;
    private int rooms;
    private final double STANDART_SQUARE = 50.0;
    private final int STANDART_ROOMS = 2;

    public Flat() {
        this.square = STANDART_SQUARE;
        this.rooms = STANDART_ROOMS;
    }

    public Flat(double square) {
        this.square = square;
        this.rooms = STANDART_ROOMS;
    }

    public Flat(double square, int numberOfRooms){
        this.square = square;
        this.rooms = numberOfRooms;
    }

    public double getSquare() {
        return square;
    }

    public Flat setSquare(double square) {
        this.square = square;
        return this;
    }

    public int getRooms() {
        return rooms;
    }

    public Flat setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }
}
