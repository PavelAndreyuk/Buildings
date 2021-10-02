package buildings.dwelling.hotel;

import buildings.dwelling.Dwelling;
import buildings.dwelling.Flat;
import interfaces.Floor;
import interfaces.Space;

import java.util.List;

public class Hotel extends Dwelling {

    public Hotel() {
        super();
    }

    public Hotel(int numberOfFloors, int[] spaces) {
        super(numberOfFloors, spaces);
    }

    public Hotel(List<Floor> floors) {
        super(floors);
    }

    public int getStars() {
        int stars = 0;
        for (int i = 0; i < super.getNumberOfFloors(); i++) {
            Floor floor = super.getFloor(i);
            if (floor instanceof HotelFloor && ((HotelFloor) floor).getStars() > stars)
                stars = ((HotelFloor) floor).getStars();
        }
        return stars;
    }

    @Override
    public Space getBestSpace() {
        double[] mult = {0.25, 0.5, 1, 1.25, 1.5};
        Space bestSpace = new Flat(0.1);
        double bestCoef = -1, coef = 0;
        for (int i = 0; i < super.getNumberOfFloors(); i++) {
            for (int j = 0; j < super.getFloor(i).getSpaces(); j++) {
                if (super.getFloor(i) instanceof HotelFloor) {
                    int stars = ((HotelFloor) super.getFloor(i)).getStars();
                    if (super.getFloor(i).getSpace(j).getSquare() * mult[stars - 1] > bestCoef) {
                        bestCoef = super.getFloor(i).getSpace(j).getSquare() * mult[stars - 1];
                        bestSpace = super.getFloor(i).getSpace(j);
                    }
                }
            }
        }
        return bestCoef > coef ? bestSpace : null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("HotelBuilding(").append(getStars() + ", ").append(getNumberOfFloors());
        for (int i = 0; i < super.getNumberOfFloors(); i++) {
            str.append(", ");
            str.append(super.getFloor(i));
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Hotel)) return false;
        if (!(((Hotel) o).getNumberOfFloors() == this.getNumberOfFloors())) return false;
        for (int i = 0; i < this.getNumberOfFloors(); i++) {
            if (!(((Hotel) o).getFloor(i).equals(this.getFloor(i)))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
