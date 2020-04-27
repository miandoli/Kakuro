package game;

public class ConstraintSquare extends Square {
    private Constraint down;
    private Constraint right;

    public Constraint getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = new Constraint(down);
    }

    public Constraint getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = new Constraint(right);
    }

    @Override
    public SquareType getSquareType() {
        return SquareType.CONSTRAINT;
    }

    @Override
    public String toString() {
        String down = getDown() != null ? String.format("%1$2s", getDown().getSum()) : "  ";
        String right = getRight() != null ? String.format("%1$2s", getRight().getSum()) : "  ";
        return down + "/" + right;
    }

    static class Constraint {
        private final int sum;

        public Constraint(int sum) {
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }
    }
}
