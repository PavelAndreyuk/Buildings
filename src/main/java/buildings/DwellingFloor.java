package buildings;

import java.util.ArrayList;
import java.util.List;

public class DwellingFloor {
    List<Flat> floor;

    public DwellingFloor(int numberOfFlats) {
        floor = new ArrayList<>(numberOfFlats);
        for (int i = 0; i < numberOfFlats; i++) {
            floor.add(new Flat());
        }
    }

    public DwellingFloor(List<Flat> floor) {
        this.floor = floor;
    }

    public int getNumberOfFlats() {
        return floor.size();
    }

    public double getTotalSquare() {
        double sum = 0;
        for (Flat fl : floor) {
            sum += fl.getSquare();
        }
        return sum;
    }

    public int getTotalNumberOfRooms() {
        int sum = 0;
        for (Flat fl : floor) {
            sum += fl.getRooms();
        }
        return sum;
    }

    public List<Flat> getFlatsArray() {
        return this.floor;
    }

    public Flat getFlat(int flatNumber) {
        return floor.get(flatNumber);
    }

    public void setFlat(int flatNumber, Flat flat) {
        floor.set(flatNumber, flat);
    }

    public void addFlat(int flatNumber, Flat flat) {
        floor.add(flatNumber, flat);
    }

    public void removeFlat(int flatNumber) {
        floor.remove(flatNumber);
    }

    public Flat getBestSpace() {
        double max = floor.get(0).getSquare();
        Flat flat = floor.get(0);
        for (int i = 0; i < floor.size(); i++) {
            if (floor.get(i).getSquare() > max) {
                max = floor.get(i).getSquare();
                flat = floor.get(i);
            }
        }
        return flat;
    }

}
