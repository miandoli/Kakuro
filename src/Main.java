import game.Board;
import game.BoardBuilder;

public class Main {
    public static void main(String[] args) {
        Board board = BoardBuilder.createBoard("/resources/large-board.json");
        System.out.println(board);
    }
}
