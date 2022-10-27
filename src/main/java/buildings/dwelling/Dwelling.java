package buildings.dwelling;

import exceptions.FloorIndexOutOfBoundException;
import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Building;
import interfaces.Floor;
import interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dwelling implements Building, Serializable {
    private final List<Floor> dwelling;

    public Dwelling() {
        dwelling = new ArrayList<>();
    }

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
        for (Floor spaces : dwelling) {
            sum += spaces.getSpaces();
        }
        return sum;
    }

    @Override
    public double getSquare() {
        double sum = 0;
        for (Floor spaces : dwelling) {
            sum += spaces.getSquare();
        }
        return sum;
    }

    @Override
    public int getRooms() {
        int sum = 0;
        for (Floor spaces : dwelling) {
            sum += spaces.getRooms();
        }
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
    public Space getSpace(int indexOfFlat) {
        if (indexOfFlat < 0) throw new SpaceIndexOutOfBoundException("Wrong number");

        int count = 0, exc = 0;
        int floorCounter, spacesOnFloorCounter;
        Space flat = new Flat();
        for (floorCounter = 0; floorCounter < dwelling.size(); floorCounter++) {
            for (spacesOnFloorCounter = 0; spacesOnFloorCounter < dwelling.get(floorCounter).getSpaces(); spacesOnFloorCounter++) {
                if (count == indexOfFlat) {
                    flat = dwelling.get(floorCounter).getSpace(spacesOnFloorCounter);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        return flat;
    }

    @Override
    public void setSpace(int indexOfFlat, Space flat) {
        if (indexOfFlat < 0) throw new SpaceIndexOutOfBoundException("Wrong number");

        int count = 0, exc = 0;
        int i, j;
        for (i = 0; i < dwelling.size(); i++) {
            for (j = 0; j < dwelling.get(i).getSpaces(); j++) {
                if (count == indexOfFlat) {
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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Dwelling(").append(getNumberOfFloors());
        for (int i = 0; i < dwelling.size(); i++) {
            str.append(", ");
            str.append(dwelling.get(i));
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Dwelling)) return false;
        if (!(((Dwelling) o).getNumberOfFloors() == this.getNumberOfFloors())) return false;
        for (int i = 0; i < this.getNumberOfFloors(); i++) {
            if (!(((Dwelling) o).getFloor(i).equals(this.getFloor(i)))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = getNumberOfFloors();
        for (Floor floor : dwelling) hash ^= floor.hashCode();
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<Floor> newDwelling = new ArrayList<>();
        for (int i = 0; i < getNumberOfFloors(); i++) {
            newDwelling.add((Floor) this.getFloor(i).clone());
        }
        return new Dwelling(newDwelling);
    }

    public Iterator<Floor> iterator() {
        return new FloorIterator(this);
    }

    private static class FloorIterator implements Iterator<Floor> {
        private final Building building;
        private int index;

        public FloorIterator(Building building) {
            this.building = building;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < building.getNumberOfFloors();
        }

        @Override
        public Floor next() {
            index++;
            return building.getFloor(index);
        }
    }
}
