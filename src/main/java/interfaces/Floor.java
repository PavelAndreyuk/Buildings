package interfaces;

import java.util.List;

public interface Floor {
    int getSpaces();

    double getSquare();

    int getRooms();

    List<Space> getFloor();

    Space getSpace(int index);

    void setSpace(int index, Space space);

    void addSpace(int index, Space space);

    void removeSpace(int index);

    Space getBestSpace();

    Object clone() throws CloneNotSupportedException;
}
