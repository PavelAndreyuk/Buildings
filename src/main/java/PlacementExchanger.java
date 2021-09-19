import exceptions.FloorIndexOutOfBoundException;
import exceptions.InexchangeableFloorsException;
import exceptions.InexchangeableSpacesException;
import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Building;
import interfaces.Floor;
import interfaces.Space;

public class PlacementExchanger {
    public static boolean isSpaceExchange(Space space1, Space space2) {
        if (space1.getRooms() == space2.getRooms() && space1.getSquare() == space2.getSquare()) return true;
        return false;
    }

    public static boolean isFloorExchange(Floor floor1, Floor floor2) {
        if (floor1.getSpaces() == floor2.getSpaces() && floor1.getSquare() == floor2.getSquare()) return true;
        return false;
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException {
        if (index1 < 0 || index2 < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        if (isSpaceExchange(floor1.getSpace(index1), floor2.getSpace(index2))) {
            Space tmp = floor1.getSpace(index1);
            floor1.setSpace(index1, floor2.getSpace(index2));
            floor2.setSpace(index2, tmp);
        } else throw new InexchangeableSpacesException("Spaces cant be exchanged");
    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException {
        if (index1 < 0 || index2 < 0) throw new FloorIndexOutOfBoundException("Wrong number");
        if (isFloorExchange(building1.getFloor(index1), building2.getFloor(index2))) {
            Floor tmp = building1.getFloor(index1);
            building1.setFloor(index1, building2.getFloor(index2));
            building2.setFloor(index2, tmp);
        } else throw new InexchangeableFloorsException("Floors cant be exchanged");
    }
}
