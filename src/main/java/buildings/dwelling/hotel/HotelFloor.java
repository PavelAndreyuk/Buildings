package buildings.dwelling.hotel;

import buildings.dwelling.DwellingFloor;
import interfaces.Space;

import java.util.List;

public class HotelFloor extends DwellingFloor {

    private int stars;
    private int STANDART_STARS = 1;

    public HotelFloor() {
        super();
    }

    public HotelFloor(int spaces) {
        super(spaces);
        this.stars = STANDART_STARS;
    }

    public HotelFloor(List<Space> spaces) {
        super(spaces);
        this.stars = STANDART_STARS;
    }

    public int getStars() {
        return stars;
    }

    public HotelFloor setStars(int stars) {
        this.stars = stars;
        return this;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("HotelFloor(").append(getStars());
        str.append(", ");
        str.append(super.getSpaces());
        for (int i = 0; i < super.getSpaces(); i++) {
            str.append(", ");
            str.append(super.getSpace(i));
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof HotelFloor)) return false;
        if (!(this.getSpaces() == ((HotelFloor) o).getSpaces())) return false;
        if (!(this.getStars() == ((HotelFloor) o).getStars())) return false;
        for (int i = 0; i < this.getSpaces(); i++) {
            if (!(((HotelFloor) o).getSpace(i).equals(this.getSpace(i)))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode()^stars;
    }
}
