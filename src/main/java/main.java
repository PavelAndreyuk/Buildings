import buildings.dwelling.Dwelling;
import buildings.dwelling.Flat;
import buildings.dwelling.hotel.Hotel;
import buildings.dwelling.hotel.HotelFloor;
import exceptions.InexchangeableSpacesException;
import interfaces.Floor;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) throws InexchangeableSpacesException {
        int flats[] = {5, 6, 6, 10};
        Floor first = new HotelFloor(5);
        Floor second = new HotelFloor(6);
        List<Floor> floors = new ArrayList<>();
        floors.add(first);
        floors.add(second);
        System.out.println(new Hotel(floors));
//        new Flat(0);
        System.out.println(new Flat());
//        int rand[] = {1, 2, 3};
//        Flat zero = new Flat(54.2, 2);
//        Flat zero1 = new Flat(54.2, 2);
//        System.out.println(zero.getSquare()+ " " + zero1.getSquare());
//        System.out.println(zero.equals(zero1));
//        System.out.println(zero1.equals(zero));
//        System.out.println(zero1.equals(zero1));
//        Flat one = new Flat(100.56, 3);
//        System.out.println(zero.equals(one));
////        System.out.println(one);
//        Flat two = new Flat(110.56, 3);
//        Dwelling dwel = new Dwelling(3, rand);
//        Dwelling dwel1 = new Dwelling(3, rand);
//        dwel.equals(dwel1);
//        System.out.println("TEst " + dwel.equals(dwel1));
//        dwel.setSpace(0, zero);
//        dwel.setSpace(1, one);
//        dwel.setSpace(2, two);
        //int flats1[] = {1, 1, 1, 1};
//        int offices[] = {1, 1, 1, 10};
//        Flat twelve = new Flat(52.4, 2);
//        Flat twentyOne = new Flat(100, 4);
////        Flat test = new Flat(100, -50);
//        Flat one = new Flat(38.5, 1);
//        Flat twentyFour = new Flat(45, 1);
//        Office oneO = new Office();
//        OfficeBuilding officeBuilding = new OfficeBuilding(4, offices);
//        Dwelling dwelling = new Dwelling(4, flats);
        //Dwelling dwelling1 = new Dwelling(4, flats1);
//        System.out.println("Total number of flats: " + dwelling.getSpaces());
        // System.out.println(dwelling1.getSpaces());

//        dwelling.setSpace(12, twelve);
//        dwelling.setSpace(21, one);
//        dwelling.setSpace(0, one);
//        dwelling.addSpace(22, twentyFour);
//        dwelling.addSpace(12, twentyFour);

//        for (int i = 0; i < 20; i++) {
//            dwelling.removeSpace(i);
//        }
//        Flat nine = new Flat(100, 4);
//        Flat fourteen = new Flat(100, 4);
//        dwelling.setSpace(9, nine);
//        dwelling.setSpace(15, fourteen);

//        System.out.println("Flat 0 has " + dwelling.getSpace(0).getSquare() + " square and " + dwelling.getSpace(0).getRooms() + " rooms");
//        System.out.println("Flat 8 has " + dwelling.getSpace(8).getSquare() + " square and " + dwelling.getSpace(8).getRooms() + " rooms");
//        System.out.println("Flat 12 has " + dwelling.getSpace(12).getSquare() + " square and " + dwelling.getSpace(12).getRooms() + " rooms");
//        System.out.println("Flat 21 has " + dwelling.getSpace(21).getSquare() + " square and " + dwelling.getSpace(21).getRooms() + " rooms");
//        System.out.println(dwelling.getBestSpace());
//        System.out.println("Flat 23 has " + dwelling.getSpace(23).getSquare() + " square and " + dwelling.getSpace(23).getRooms() + " rooms");
//        System.out.println("Total number of flats: " + dwelling.getSpaces());
//        System.out.println("Total number of rooms " + dwelling.getRooms());
//        System.out.println(dwelling.getSortedArray());
//        System.out.println(dwelling.getSpace(20));
//        System.out.println(dwelling.getSpace(9));
//        System.out.println(dwelling.getSpace(15));
//        System.out.println("First room " + dwelling.getFloor(1).getSpace(4).getRooms() + " " + dwelling.getFloor(1).getSpace(4).getSquare());
//        System.out.println("Second room " + dwelling.getFloor(2).getSpace(4).getRooms() + " " + dwelling.getFloor(2).getSpace(4).getSquare());
//        PlacementExchanger.exchangeFloorRooms(dwelling.getFloor(1), 4, dwelling.getFloor(2), 4);
//        System.out.println(dwelling.getSpace(9));
//        System.out.println(dwelling.getSpace(15));
//        System.out.println("Number of offices " + officeBuilding.getSpaces() + " number of floors is " + officeBuilding.getNumberOfFloors() + " total area is " + officeBuilding.getSquare());
//        OutputStreamWriter out = new OutputStreamWriter(System.out);
//        try (FileWriter fl1 = new FileWriter("test.txt");
//             FileOutputStream fl2 = new FileOutputStream("test.bin")) {
//            Buildings.writeBuilding(dwel, fl1);
//            Buildings.outputBuilding(dwel, fl2);
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
//        try (FileInputStream fl2 = new FileInputStream("test.bin");
//             FileReader fl = new FileReader("test.txt")) {
//            Building building = Buildings.inputBuilding(fl2, "dwelling");
//            Building building1 = Buildings.readBuilding(fl, "dwelling");
//            System.out.println(building.equals(building1));
//            System.out.println(building.equals(building));
////            System.out.println(building.getFloor(1));
////            System.out.println(building);
////            System.out.println("Building has " + building.getNumberOfFloors() + " floors");
////            System.out.println("Building has " + building.getSpaces() + " spaces");
////            System.out.println("First floor has " + building.getFloor(0).getSpaces() + " spaces");
////            System.out.println("Second floor has " + building.getFloor(1).getSpaces() + " spaces");
////            System.out.println("Third floor has " + building.getFloor(2).getSpaces() + " spaces");
////            System.out.println("Flat on first floor has " + building.getFloor(0).getSpace(0).getSquare() + " square and " + building.getFloor(0).getSpace(0).getRooms() + " rooms");
////            System.out.println("First flat on second floor has " + building.getFloor(1).getSpace(0).getSquare() + " square and " + building.getFloor(1).getSpace(0).getRooms() + " rooms");
////            System.out.println("Second flat on second floor has " + building.getFloor(1).getSpace(1).getSquare() + " square and " + building.getFloor(1).getSpace(1).getRooms() + " rooms");
////            System.out.println("Third floor has " + building.getFloor(2).getRooms() + " rooms and " + building.getFloor(2).getSquare() + " square");
////            System.out.println("Building has " + building.getSpaces() + " spaces");
////            System.out.println("Number of floors " + building.getNumberOfFloors() + " " + "2 floor has " + building.getFloor(2).getSpaces() + " spaces, 3 floor has " + building.getFloor(3).getSpaces() + " spaces");
////            System.out.println("Building has " + build.getNumberOfFloors() + " " + " flors, 0 floor has " + build.getFloor(0).getSpaces() + " spaces, 1 floor has - " + build.getFloor(1).getSpaces());
//        } catch (IOException e) {
//            System.out.println("Error");
//        }

//        try (FileOutputStream file = new FileOutputStream("ser.txt")) {
//            Buildings.serializeBuilding(dwelling, file);
//
//        } catch (IOException e) {
//            System.out.println("Error");
//        }
//        try (FileInputStream inputFile = new FileInputStream("ser.txt")) {
//            Building bbb = Buildings.deserialaizeBuilding(inputFile);
////            System.out.println(bbb.getSpaces());
//        } catch (IOException | ClassNotFoundException e) {
//            System.out.println("Error");
//        }

    }
}
