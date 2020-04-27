package game;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;


public class BoardBuilder {
    public static Board createBoard(String fileName) {
        JSONParser parser = new JSONParser();
        try {
            String absolutePath = new File("").getAbsolutePath() + fileName;
            JSONObject root = (JSONObject) parser.parse(new FileReader(absolutePath));

            String name = (String) root.get("name");
            int height = (int) ((long) root.get("height"));
            int width = (int) ((long) root.get("width"));
            Board board = new Board(name, height, width);

            JSONArray rows = (JSONArray) root.get("rows");
            Iterator rowsIterator = rows.iterator();
            int i = 0;
            while (rowsIterator.hasNext()) {
                JSONObject rowRoot = (JSONObject) rowsIterator.next();
                JSONArray row = (JSONArray) rowRoot.get("row");
                Iterator rowIterator = row.iterator();
                int j = 0;
                while (rowIterator.hasNext()) {
                    JSONObject squareRoot = (JSONObject) rowIterator.next();
                    Square square = createSquare(squareRoot);
                    board.setSquare(square, i, j);
                    j++;
                }
                i++;
            }
            return board;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Square createSquare(JSONObject squareRoot) {
        SquareType squareType = SquareType.valueOf((String) squareRoot.get("type"));
        switch (squareType) {
            case EMPTY:
                return new EmptySquare();
            case CONSTRAINT:
                ConstraintSquare square = new ConstraintSquare();
                Object down = squareRoot.get("down");
                if (down != null) {
                    square.setDown((int) ((long) down));
                }
                Object right = squareRoot.get("right");
                if (right != null) {
                    square.setRight((int) ((long) right));
                }
                return square;
            case CELL:
                return new CellSquare();
        }
        return null;
    }
}
