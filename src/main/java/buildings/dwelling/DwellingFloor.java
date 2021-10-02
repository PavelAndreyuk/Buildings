package buildings.dwelling;

import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Floor;
import interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DwellingFloor implements Floor, Serializable, Cloneable {
    private List<Space> floor;

    public DwellingFloor() {
        floor = new ArrayList<>();
    }

    public DwellingFloor(int flats) {
        floor = new ArrayList<>(flats);
        for (int i = 0; i < flats; i++) {
            floor.add(new Flat());
        }
    }

    public DwellingFloor(List<Space> flats) {
        this.floor = flats;
    }

    @Override
    public int getSpaces() {
        return floor.size();
    }

    @Override
    public double getSquare() {
        double sum = 0;
        for (Space flats : floor) {
            sum += flats.getSquare();
        }
        return sum;
    }

    @Override
    public int getRooms() {
        int sum = 0;
        for (Space flats : floor) {
            sum += flats.getRooms();
        }
        return sum;
    }

    @Override
    public List<Space> getFloor() {
        return this.floor;
    }

    @Override
    public Space getSpace(int index) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        return floor.get(index);
    }

    @Override
    public void setSpace(int index, Space flat) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.set(index, flat);
    }

    @Override
    public void addSpace(int index, Space flat) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.add(index, flat);
    }

    @Override
    public void removeSpace(int index) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.remove(index);
    }

    @Override
    public Space getBestSpace() {
        double max = floor.get(0).getSquare();
        Space flat = floor.get(0);
        for (int i = 0; i < floor.size(); i++) {
            if (floor.get(i).getSquare() > max) {
                max = floor.get(i).getSquare();
                flat = floor.get(i);
            }
        }
        return flat;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("DwellingFloor(").append(getSpaces());
        for (int i = 0; i < floor.size(); i++) {
            str.append(", ");
            str.append(floor.get(i));
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof DwellingFloor)) return false;
        if (!(this.getSpaces() == ((DwellingFloor) o).getSpaces())) return false;
        for (int i = 0; i < this.getSpaces(); i++) {
            if (!(((DwellingFloor) o).getSpace(i).equals(this.getSpace(i)))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = getSpaces();
        for (Space space : floor) hash ^= space.hashCode();
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        DwellingFloor newFloor = new DwellingFloor(getSpaces());
        for (int i = 0; i < getSpaces(); i++) {
            newFloor.setSpace(i, (Space) (this.getSpace(i)).clone());
        }
        return newFloor;
    }
}
