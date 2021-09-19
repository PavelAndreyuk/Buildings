package exceptions;

public class InvalidRoomsCountException extends IllegalArgumentException {
    public InvalidRoomsCountException(String msg) {
        super(msg);
    }
}
