package buildings.office;

import exceptions.FloorIndexOutOfBoundException;
import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Building;
import interfaces.Floor;
import interfaces.Space;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OfficeBuilding implements Building, Serializable {
    private List<Floor> building;

    public OfficeBuilding(int numberOfFloors, int[] offices) {
        building = new LinkedList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            building.add(new OfficeFloor(offices[i]));
        }
    }

    public OfficeBuilding(List<Floor> floors) {
        this.building = floors;
    }

    @Override
    public int getNumberOfFloors() {
        return building.size();
    }

    @Override
    public int getSpaces() {
        int sum = 0;
        for (int i = 0; i < building.size(); i++) {
            sum += building.get(i).getSpaces();
        }
        return sum;
    }

    @Override
    public double getSquare() {
        double sum = 0;
        for (int i = 0; i < building.size(); i++) {
            sum += building.get(i).getSquare();
        }
        return sum;
    }

    @Override
    public int getRooms() {
        int sum = 0;
        for (int i = 0; i < building.size(); i++) {
            sum += building.get(i).getRooms();
        }
        return sum;
    }

    @Override
    public List<Floor> getFloors() {
        return this.building;
    }

    @Override
    public Floor getFloor(int index) {
        if (index < 0 || index > building.size()) throw new FloorIndexOutOfBoundException("Wrong number");
        return building.get(index);
    }

    @Override
    public void setFloor(int index, Floor floor) {
        if (index < 0 || index > building.size()) throw new FloorIndexOutOfBoundException("Wrong number");
        building.set(index, floor);
    }

    @Override
    public Space getSpace(int index) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        Space office = new Office();
        for (i = 0; i < building.size(); i++) {
            for (j = 0; j < building.get(i).getSpaces(); j++) {
                if (count == index) {
                    office = building.get(i).getSpace(j);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        return office;
    }

    @Override
    public void setSpace(int index, Space office) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        for (i = 0; i < building.size(); i++) {
            for (j = 0; j < building.get(i).getSpaces(); j++) {
                if (count == index) {
                    building.get(i).setSpace(j, office);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new FloorIndexOutOfBoundException("Wrong number");
    }

    @Override
    public void addSpace(int index, Space office) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0;
        int i, j;
        for (i = 0; i < building.size(); i++) {
            for (j = 0; j < building.get(i).getSpaces(); j++) {
                if (count == index) building.get(i).addSpace(j, office);
                count++;
            }
        }
    }

    @Override
    public void removeSpace(int index) {
        if (index < 0) throw new SpaceIndexOutOfBoundException("Wrong number");
        int count = 0, exc = 0;
        int i, j;
        for (i = 0; i < building.size(); i++) {
            for (j = 0; j < building.get(i).getSpaces(); j++) {
                if (count == index) {
                    building.get(i).removeSpace(j);
                    exc = 100;
                }
                count++;
            }
        }
        if (exc == 0) throw new FloorIndexOutOfBoundException("Wrong number");
    }

    @Override
    public Space getBestSpace() {
        Space office = building.get(0).getBestSpace();
        double max = building.get(0).getBestSpace().getSquare();
        for (int i = 0; i < building.size(); i++) {
            if (building.get(i).getBestSpace().getSquare() > max)
                office = building.get(i).getBestSpace();
        }
        return office;
    }

    @Override
    public List<Space> getSortedArray() {
        List<Space> offices = new LinkedList<>();
        for (int i = 0; i < building.size(); i++)
            for (int j = 0; j < building.get(i).getSpaces(); j++)
                offices.add(building.get(i).getSpace(j));
        for (int k = offices.size() - 1; k >= 1; k--) {
            for (int l = 0; l < k; l++) {
                if (offices.get(l).getSquare() > offices.get(l + 1).getSquare()) {
                    double tmp = offices.get(l).getSquare();
                    offices.get(l).setSquare(offices.get(l + 1).getSquare());
                    offices.get(l + 1).setSquare(tmp);
                }
            }
        }
        return offices;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Dwelling(").append(getNumberOfFloors());
        for (int i = 0; i < building.size(); i++) {
            str.append(", ");
            str.append(building.get(i));
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof OfficeBuilding)) return false;
        if (!(((OfficeBuilding) o).getNumberOfFloors() == this.getNumberOfFloors())) return false;
        for (int i = 0; i < this.getNumberOfFloors(); i++) {
            if (!(((OfficeBuilding) o).getFloor(i).equals(this.getFloor(i)))) return false;
        }
        return true;
    }
}
