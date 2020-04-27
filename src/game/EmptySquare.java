package game;

public class EmptySquare extends Square {
    @Override
    public SquareType getSquareType() {
        return SquareType.EMPTY;
    }

    @Override
    public String toString() {
        return "-----";
    }
}
