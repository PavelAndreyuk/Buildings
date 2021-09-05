package buildings;

import java.util.ArrayList;
import java.util.List;

public class Dwelling {
    List<DwellingFloor> dwelling;

    public Dwelling(int numberOfFloors, int[] numberOfFlats) {
        dwelling = new ArrayList<>(numberOfFloors);
        for (int i = 0; i < numberOfFloors; i++) {
            dwelling.add(new DwellingFloor(numberOfFlats[i]));
        }
    }

    public Dwelling(ArrayList<DwellingFloor> floors) {
        this.dwelling = floors;

    }

    public int getNumberOfFloors() {
        return dwelling.size();
    }

    public int getTotalNumberOfFlats() {
        int sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getNumberOfFlats();
        return sum;
    }

    public double getTotalSquare() {
        double sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getTotalSquare();
        return sum;
    }

    public int getTotalNumberOfRooms() {
        int sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getTotalNumberOfRooms();
        return sum;
    }

    public List<DwellingFloor> getDwelling() {
        return this.dwelling;
    }

    public DwellingFloor getDwellingFloor(int numberOfDwellingFloor) {
        return dwelling.get(numberOfDwellingFloor);
    }

    public void setDwellingFloor(int numberOfDwellingFloor, DwellingFloor floor) {
        dwelling.set(numberOfDwellingFloor, floor);
    }

    public Flat getFlat(int numberOfFlat) {
        int count = 0;
        int i, j;
        Flat fl = new Flat();
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getNumberOfFlats(); j++) {
                if (count == numberOfFlat) fl = dwelling.get(i).getFlat(j);
                count++;
            }
        }
        return fl;
    }

    public void setFlat(int numberOfFlat, Flat flat) {
        int count = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getNumberOfFlats(); j++) {
                if (count == numberOfFlat) dwelling.get(i).setFlat(j, flat);
                count++;
            }
        }
    }

    public void addFlat(int numberOfFlat, Flat flat) {
        int count = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getNumberOfFlats(); j++) {
                if (count == numberOfFlat) dwelling.get(i).addFlat(j, flat);
                count++;
            }
        }
    }

    public void removeFlat(int numberOfFlat) {
        int count = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getNumberOfFlats(); j++) {
                if (count == numberOfFlat) dwelling.get(i).removeFlat(j);
                count++;
            }
        }
    }

    public Flat getBestSpace() {
        Flat flat = dwelling.get(0).getBestSpace();
        double max = dwelling.get(0).getBestSpace().getSquare();
        for (int i = 0; i < dwelling.size(); i++) {
            if (dwelling.get(i).getBestSpace().getSquare() > max)
                flat = dwelling.get(i).getBestSpace();
        }
        return flat;
    }

    public List<Flat> getSortedArray() {
        List<Flat> flats = new ArrayList<>();
        for (int i = 0; i < dwelling.size(); i++)
            for (int j = 0; j < dwelling.get(i).getNumberOfFlats(); j++)
                flats.add(dwelling.get(i).getFlat(j));
        for (int k = flats.size() - 1; k >= 1; k--) {
            for (int l = 0; l < k; l++) {
                if (flats.get(l).getSquare() > flats.get(l + 1).getSquare()) {
                    double tmp = flats.get(l).getSquare();
                    flats.get(l).setSquare(flats.get(l + 1).getSquare());
                    flats.get(l + 1).setSquare(tmp);
                }
            }
        }
        return flats;
    }
}
