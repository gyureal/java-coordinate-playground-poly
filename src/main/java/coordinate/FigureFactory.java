package coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * FigureFactory
 * points의 size()에 따라 다른 객체를 생성해 반환한다.
 */
public class FigureFactory {

    private static final Map<Integer, Function<List<Point>, Figure>> creators = new HashMap<>(); // static 선언 필수

    static {
        creators.put(Line.LINE_POINT_SIZE, Line::new);       // method reference 변환 가능
        creators.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
        creators.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
    }

    static Figure getInstance(List<Point> points) {
        Function<List<Point>, Figure> creator = creators.getOrDefault(points.size(), null);
        if (creator != null) {
            return creator.apply(points);
        }

        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}
