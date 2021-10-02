package buildings.office;

import buildings.dwelling.DwellingFloor;
import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Floor;
import interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OfficeFloor implements Floor, Serializable {
    private List<Space> floor;

    public OfficeFloor(int offices) {
        floor = new ArrayList<>(offices);
        for (int i = 0; i < offices; i++) {
            floor.add(new Office());
        }
    }

    public OfficeFloor(List<Space> offices) {
        this.floor = offices;
    }

    @Override
    public int getSpaces() {
        return floor.size();
    }

    @Override
    public double getSquare() {
        double sum = 0;
        for (Space offices : floor) {
            sum += offices.getSquare();
        }
        return sum;
    }

    @Override
    public int getRooms() {
        int sum = 0;
        for (Space offices : floor) {
            sum += offices.getRooms();
        }
        return sum;
    }

    @Override
    public List<Space> getFloor() {
        return floor;
    }

    @Override
    public Space getSpace(int index) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        return floor.get(index);
    }

    @Override
    public void setSpace(int index, Space office) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.set(index, office);
    }

    @Override
    public void addSpace(int index, Space office) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.add(index, office);
    }

    @Override
    public void removeSpace(int index) {
        if (index < 0 || index > floor.size()) throw new SpaceIndexOutOfBoundException("Wrong number");
        floor.remove(index);
    }

    @Override
    public Space getBestSpace() {
        double max = floor.get(0).getSquare();
        Space office = floor.get(0);
        for (Space space : floor) {
            if (space.getSquare() > max) {
                max = space.getSquare();
                office = space;
            }
        }
        return office;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("OfficeFloor(").append(getSpaces());
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
        if (!(o instanceof OfficeFloor)) return false;
        if (!(this.getSpaces() == ((OfficeFloor) o).getSpaces())) return false;
        for (int i = 0; i < this.getSpaces(); i++) {
            if (!(((OfficeFloor) o).getSpace(i).equals(this.getSpace(i)))) return false;
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
        OfficeFloor newFloor = new OfficeFloor(getSpaces());
        for (int i = 0; i < getSpaces(); i++) {
            newFloor.setSpace(i, (Space) (this.getSpace(i)).clone());
        }
        return newFloor;
    }

    public Iterator<Space> iterator() {
        return new spaceIterator(this);
    }

    private class spaceIterator implements Iterator<Space> {
        private int index;
        private Floor floor;

        spaceIterator(Floor floor) {
            this.floor = floor;
            index = -1;
        }

        @Override
        public boolean hasNext() {
            return index + 1 < floor.getSpaces();
        }

        @Override
        public Space next() {
            index++;
            return floor.getSpace(index);
        }
    }

    @Override
    public int compareTo(Floor o) {
        if (this.getSpaces() == o.getSpaces()) return 0;
        return this.getSpaces() - o.getSpaces() > 0 ? -1 : 1;
    }
}
