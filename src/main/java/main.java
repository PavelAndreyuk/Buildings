import buildings.Dwelling;
import buildings.DwellingFloor;
import buildings.Flat;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        int flats[] = {5, 6, 6, 6};
        Flat twelve = new Flat(52.4, 2);
        Flat twentyOne = new Flat(100, 4);
        Flat one = new Flat(38.5, 1);
        Flat twentyFour = new Flat(45, 1);


        Dwelling dwelling = new Dwelling(4, flats);
        System.out.println("Total number of flats: " + dwelling.getTotalNumberOfFlats());

        dwelling.setFlat(12, twelve);
        dwelling.setFlat(21, twentyOne);
        dwelling.setFlat(0, one);
        dwelling.addFlat(22, twentyFour);
        dwelling.addFlat(12, twentyFour);

        for (int i = 0; i < 20; i++) {
            dwelling.removeFlat(i);
        }


        System.out.println("Flat 0 has " + dwelling.getFlat(0).getSquare() + " square and " + dwelling.getFlat(0).getRooms() + " rooms");
        System.out.println("Flat 8 has " + dwelling.getFlat(8).getSquare() + " square and " + dwelling.getFlat(8).getRooms() + " rooms");
//        System.out.println("Flat 12 has " + dwelling.getFlat(12).getSquare() + " square and " + dwelling.getFlat(12).getRooms() + " rooms");
//        System.out.println("Flat 21 has " + dwelling.getFlat(21).getSquare() + " square and " + dwelling.getFlat(21).getRooms() + " rooms");
//        System.out.println(dwelling.getBestSpace());
//        System.out.println("Flat 23 has " + dwelling.getFlat(23).getSquare() + " square and " + dwelling.getFlat(23).getRooms() + " rooms");
        System.out.println("Total number of flats: " + dwelling.getTotalNumberOfFlats());
        System.out.println("Total number of rooms " + dwelling.getTotalNumberOfRooms());
        System.out.println(dwelling.getSortedArray());


    }
}
