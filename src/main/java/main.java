import buildings.Dwelling;
import buildings.Flat;
import offices.Office;
import offices.OfficeBuilding;

public class main {
    public static void main(String[] args) {
        int flats[] = {5, 6, 6, 6};
        int offices[] = {1, 1, 1, 10};
//        Flat twelve = new Flat(52.4, 2);
        Flat twentyOne = new Flat(100, 4);
//        Flat one = new Flat(38.5, 1);
//        Flat twentyFour = new Flat(45, 1);
        Office one = new Office();
        OfficeBuilding officeBuilding = new OfficeBuilding(4, offices);
        Dwelling dwelling = new Dwelling(4, flats);
//        System.out.println("Total number of flats: " + dwelling.getSpaces());

//        dwelling.setSpace(12, twelve);
//        dwelling.setSpace(21, one);
//        dwelling.setSpace(0, one);
//        dwelling.addSpace(22, twentyFour);
//        dwelling.addSpace(12, twentyFour);

//        for (int i = 0; i < 20; i++) {
//            dwelling.removeSpace(i);
//        }


//        System.out.println("Flat 0 has " + dwelling.getSpace(0).getSquare() + " square and " + dwelling.getSpace(0).getRooms() + " rooms");
//        System.out.println("Flat 8 has " + dwelling.getSpace(8).getSquare() + " square and " + dwelling.getSpace(8).getRooms() + " rooms");
//        System.out.println("Flat 12 has " + dwelling.getSpace(12).getSquare() + " square and " + dwelling.getSpace(12).getRooms() + " rooms");
//        System.out.println("Flat 21 has " + dwelling.getSpace(21).getSquare() + " square and " + dwelling.getSpace(21).getRooms() + " rooms");
//        System.out.println(dwelling.getBestSpace());
//        System.out.println("Flat 23 has " + dwelling.getSpace(23).getSquare() + " square and " + dwelling.getSpace(23).getRooms() + " rooms");
//        System.out.println("Total number of flats: " + dwelling.getSpaces());
//        System.out.println("Total number of rooms " + dwelling.getRooms());
//        System.out.println(dwelling.getSortedArray());
        System.out.println("Number of offices " + officeBuilding.getSpaces() + " number of floors is " + officeBuilding.getNumberOfFloors() + " total area is " + officeBuilding.getSquare());

    }
}
