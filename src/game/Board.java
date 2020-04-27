package game;

public class Board {
    private final String name;
    private final int height, width;
    private Square[][] board;

    public Board(String name, int height, int width) {
        this.name = name;
        this.height = height;
        this.width = width;
        board = new Square[height][width];
    }

    public Square getSquare(int x, int y) {
        return board[x][y];
    }

    public void setSquare(Square square, int x, int y) {
        board[x][y] = square;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        for (int i = 0; i < height; i++) {
            stringBuilder.append("\n");
            for (int j = 0; j < width; j++) {
                stringBuilder.append("|").append(board[i][j]);
            }
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
