package book.chap13;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Ellipse> resizableShapes = Arrays.asList(new Square(), new Rectangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}
