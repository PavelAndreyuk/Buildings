import buildings.*;
import interfaces.*;
import offices.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Buildings {
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
    public static Building inputBuilding(InputStream in, String type) throws IOException {
        DataInputStream input = new DataInputStream(in);
        List<Floor> floors;
        Floor floor;
        if (type == "dwelling") {
            floors = new ArrayList<>();
            int floorsCount = input.readInt();
            for (int i = 0; i < floorsCount; i++) {
                List<Space> spaces = new ArrayList<>();
                int spaceCount = input.readInt();
                for (int j = 0; j < spaceCount; j++) {
                    int rooms = input.readInt();
                    double square = input.readDouble();
                    spaces.add(new Flat(square, rooms));
                }
                floor = new DwellingFloor(spaces);
                floors.add(floor);
            }
            return new Dwelling(floors);
        }
        if (type == "office") {
            floors = new ArrayList<>();
            int floorsCount = input.readInt();
            for (int i = 0; i < floorsCount; i++) {
                List<Space> spaces = new ArrayList<>();
                int spaceCount = input.readInt();
                for (int j = 0; j < spaceCount; j++) {
                    int rooms = input.readInt();
                    double square = input.readDouble();
                    spaces.add(new Office(square, rooms));
                }
                floor = new OfficeFloor(spaces);
                floors.add(floor);
            }
            return new OfficeBuilding(floors);
        }
        return null;
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
    public static Building readBuilding(Reader in, String type) throws IOException {
        StreamTokenizer input = new StreamTokenizer(in);
        List<Floor> floors;
        Floor floor;
        if (type == "dwelling") {
            floors = new ArrayList<>();
            input.nextToken();
            int floorsCount = (int)input.nval;
            for (int i = 0; i < floorsCount; i++) {
                List<Space> spaces = new ArrayList<>();
                input.nextToken();
                int spaceCount = (int)input.nval;
                for (int j = 0; j < spaceCount; j++) {
                    input.nextToken();
                    int rooms = (int)input.nval;
                    input.nextToken();
                    double square = input.nval;
                    spaces.add(new Flat(square, rooms));
                }
                floor = new DwellingFloor(spaces);
                floors.add(floor);
            }
            return new Dwelling(floors);
        }
        if (type == "office") {
            floors = new ArrayList<>();
            input.nextToken();
            int floorsCount = (int)input.nval;
            for (int i = 0; i < floorsCount; i++) {
                List<Space> spaces = new ArrayList<>();
                input.nextToken();
                int spaceCount = (int)input.nval;
                for (int j = 0; j < spaceCount; j++) {
                    input.nextToken();
                    int rooms = (int)input.nval;
                    input.nextToken();
                    double square = input.nval;
                    spaces.add(new Office(square, rooms));
                }
                floor = new OfficeFloor(spaces);
                floors.add(floor);
            }
            return new OfficeBuilding(floors);
        }
        return null;
    }

    public static void serializeBuilding(Building building, OutputStream out) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(out);
        output.writeObject(building);
    }

    public static Building deserialaizeBuilding(InputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(in);
        return (Building) input.readObject();
    }
}
