package book.chap13;

import java.util.List;

public class Utils {
    public static void paint(List<Resizable> resizableShapes) {
        resizableShapes.forEach(resizeableShape -> {
            resizeableShape.setAbsoluteSize(42, 42);
            resizeableShape.draw();
        });
    }
}
