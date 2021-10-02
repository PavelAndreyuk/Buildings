package interfaces;

import java.util.List;

public interface BuildingFactory {
    Space createSpace(double area);

    Space createSpace(int roomsCount, double area);

    Floor createFloor(int spacesCount);

    Floor createFloor(List<Space> spaces);

    Building createBuilding(int floorsCount, int[] spacesCounts);

    Building createBuilding(List<Floor> floors);
}
