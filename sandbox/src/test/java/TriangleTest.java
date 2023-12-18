import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test

    void perimeterTest() {
        Triangle firstTriangle = new Triangle(3, 2, 1);
        Assertions.assertEquals(6, firstTriangle.perimeter());
    }

    @Test
    void squareTest () {
        Triangle secondTriangle = new Triangle(3, 4, 5);
        Assertions.assertEquals(secondTriangle.square(), 6 );
    }
}
