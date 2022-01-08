package interfaces;

public interface Space extends Cloneable, Comparable<Space> {
    int getRooms();

    void setRooms(int rooms);

    double getSquare();

    void setSquare(double square);

    Object clone() throws CloneNotSupportedException;
}
