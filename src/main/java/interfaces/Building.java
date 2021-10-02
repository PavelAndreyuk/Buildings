package interfaces;

import java.util.List;

public interface Building extends Cloneable, Iterable<Floor> {
    int getNumberOfFloors();

    int getSpaces();

    double getSquare();

    int getRooms();

    List<Floor> getFloors();

    Floor getFloor(int index);

    void setFloor(int index, Floor floor);

    Space getSpace(int index);

    void setSpace(int index, Space space);

    void addSpace(int index, Space space);

    void removeSpace(int index);

    Space getBestSpace();

    List<Space> getSortedArray();

    Object clone() throws CloneNotSupportedException;
}
