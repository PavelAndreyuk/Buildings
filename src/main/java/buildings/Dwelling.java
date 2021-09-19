package buildings;

import exceptions.FloorIndexOutOfBoundException;
import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Building;
import interfaces.Floor;
import interfaces.Space;

import java.util.ArrayList;
import java.util.List;

public class Dwelling implements Building {
    List<Floor> dwelling;

    public Dwelling(int numberOfFloors, int[] numberOfFlats) {
        dwelling = new ArrayList<>(numberOfFloors);
        for (int i = 0; i < numberOfFloors; i++) {
            dwelling.add(new DwellingFloor(numberOfFlats[i]));
        }
    }

    public Dwelling(List<Floor> floors) {
        this.dwelling = floors;
    }

    @Override
    public int getNumberOfFloors() {
        return dwelling.size();
    }

    @Override
    public int getSpaces() {
        int sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getSpaces();
        return sum;
    }

    @Override
    public double getSquare() {
        double sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getSquare();
        return sum;
    }

    @Override
    public int getRooms() {
        int sum = 0;
        for (int i = 0; i < dwelling.size(); i++)
            sum += dwelling.get(i).getRooms();
        return sum;
    }

    @Override
    public List<Floor> getFloors() {
        return this.dwelling;
    }

    @Override
    public Floor getFloor(int index) {
        if (index < 0 || index > dwelling.size()) throw new FloorIndexOutOfBoundException("Wrong number");
        return dwelling.get(index);
    }

    @Override
    public void setFloor(int index, Floor floor) {
        if (index < 0 || index > dwelling.size()) throw new FloorIndexOutOfBoundException("Wrong number");
        dwelling.set(index, floor);
    }

    @Override
    public Space getSpace(int index) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        Space fl = new Flat();
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getSpaces(); j++) {
                if (count == index) {
                    fl = dwelling.get(i).getSpace(j);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        return fl;
    }

    @Override
    public void setSpace(int index, Space flat) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getSpaces(); j++) {
                if (count == index) {
                    dwelling.get(i).setSpace(j, flat);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new FloorIndexOutOfBoundException("Wrong number");
    }

    @Override
    public void addSpace(int index, Space flat) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getSpaces(); j++) {
                if (count == index) dwelling.get(i).addSpace(j, flat);
                count++;
            }
        }
    }

    @Override
    public void removeSpace(int index) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getSpaces(); j++) {
                if (count == index) {
                    dwelling.get(i).removeSpace(j);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new FloorIndexOutOfBoundException("Wrong number");
    }

    @Override
    public Space getBestSpace() {
        Space flat = dwelling.get(0).getBestSpace();
        double max = dwelling.get(0).getBestSpace().getSquare();
        for (int i = 0; i < dwelling.size(); i++) {
            if (dwelling.get(i).getBestSpace().getSquare() > max)
                flat = dwelling.get(i).getBestSpace();
        }
        return flat;
    }

    @Override
    public List<Space> getSortedArray() {
        List<Space> flats = new ArrayList<>();
        for (int i = 0; i < dwelling.size(); i++)
            for (int j = 0; j < dwelling.get(i).getSpaces(); j++)
                flats.add(dwelling.get(i).getSpace(j));
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
