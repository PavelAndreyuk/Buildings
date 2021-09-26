package offices;

import exceptions.SpaceIndexOutOfBoundException;
import interfaces.Floor;
import interfaces.Space;

import java.io.Serializable;
import java.util.ArrayList;
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
        for (int i = 0; i < floor.size(); i++) {
            if (floor.get(i).getSquare() > max) {
                max = floor.get(i).getSquare();
                office = floor.get(i);
            }
        }
        return office;
    }
}
