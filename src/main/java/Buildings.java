import buildings.dwelling.*;
import buildings.office.*;
import interfaces.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Buildings {
    private static BuildingFactory buildingFactory = new DwellingFactory();

    public static void setBuildingFactory(BuildingFactory buildingFactory) {
        Buildings.buildingFactory = buildingFactory;
    }

    /*
        Write data about building using output stream of bytes
         */
    public static void outputBuilding(Building building, OutputStream out) throws IOException {
        DataOutputStream output = new DataOutputStream(out);
        output.writeInt(building.getNumberOfFloors());
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            output.writeInt(building.getFloor(i).getSpaces());
            for (int j = 0; j < building.getFloor(i).getSpaces(); j++) {
                output.writeInt(building.getFloor(i).getSpace(j).getRooms());
                output.writeDouble(building.getFloor(i).getSpace(j).getSquare());
            }
        }
    }

    /*
    Read data about building using input stream of bytes
     */
    public static Building inputBuilding(InputStream in) throws IOException {
        DataInputStream input = new DataInputStream(in);
        List<Floor> floors;
        Floor floor;
        floors = new ArrayList<>();
        int floorsCount = input.readInt();
        for (int i = 0; i < floorsCount; i++) {
            List<Space> spaces = new ArrayList<>();
            int spaceCount = input.readInt();
            for (int j = 0; j < spaceCount; j++) {
                int rooms = input.readInt();
                double square = input.readDouble();
                spaces.add(buildingFactory.createSpace(rooms, square));
            }
            floor = buildingFactory.createFloor(spaces);
            floors.add(floor);
        }
        return buildingFactory.createBuilding(floors);
    }

    /*
    Write data about building using character stream
     */
    public static void writeBuilding(Building building, Writer out) {
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.print(building.getNumberOfFloors());
        printWriter.print(' ');
        for (int i = 0; i < building.getNumberOfFloors(); i++) {
            printWriter.print(building.getFloor(i).getSpaces());
            printWriter.print(' ');
            for (int j = 0; j < building.getFloor(i).getSpaces(); j++) {
                printWriter.print(building.getFloor(i).getSpace(j).getRooms());
                printWriter.print(' ');
                printWriter.print(building.getFloor(i).getSpace(j).getSquare());
                printWriter.print(' ');
            }
        }
    }

    /*
    Read data about building using character stream
     */
    public static Building readBuilding(Reader in) throws IOException {
        StreamTokenizer input = new StreamTokenizer(in);
        List<Floor> floors;
        Floor floor;
        floors = new ArrayList<>();
        input.nextToken();
        int floorsCount = (int) input.nval;
        for (int i = 0; i < floorsCount; i++) {
            List<Space> spaces = new ArrayList<>();
            input.nextToken();
            int spaceCount = (int) input.nval;
            for (int j = 0; j < spaceCount; j++) {
                input.nextToken();
                int rooms = (int) input.nval;
                input.nextToken();
                double square = input.nval;
                spaces.add(buildingFactory.createSpace(rooms, square));
            }
            floor = buildingFactory.createFloor(spaces);
            floors.add(floor);
        }
        return buildingFactory.createBuilding(floors);
    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(out);
        output.writeObject(building);
    }

    public static Building deserialaizeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(in);
        return (Building) input.readObject();
    }

    public static Space createSpace(double area) {
        return buildingFactory.createSpace(area);
    }

    public static Space createSpace(double area, int roomsCount) {
        return buildingFactory.createSpace(roomsCount, area);
    }

    public static Floor createFloor(int spacesCount) {
        return buildingFactory.createFloor(spacesCount);
    }

    public static Floor createFloor(List<Space> spaces) {
        return buildingFactory.createFloor(spaces);
    }

    public static Building createBuilding(int floorsCount, int[] spaceCount) {
        return buildingFactory.createBuilding(floorsCount, spaceCount);
    }

    public static Building createBuilding(List<Floor> floors) {
        return buildingFactory.createBuilding(floors);
    }
}
