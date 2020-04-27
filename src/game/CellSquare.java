package game;

public class CellSquare extends Square {
    private Value value;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public SquareType getSquareType() {
        return SquareType.CELL;
    }

    @Override
    public String toString() {
        return "     ";
    }

    static class Value {
        private int value;
    }
}
