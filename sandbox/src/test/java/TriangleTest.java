import org.example.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {

    @Test

    void perimeterTest() throws MyException {
        Triangle firstTriangle = new Triangle(3, 2, 1);
        Assertions.assertEquals(6, firstTriangle.perimeter());
    }

    @Test
    void squareTest () throws MyException {
        Triangle secondTriangle = new Triangle(3, 4, 5);
        Assertions.assertEquals(secondTriangle.square(), 6 );
    }

    @Test
    void negativeSideTest () throws MyException {
        try {
            Triangle negativeTriangle = new Triangle(-1, 0, 2);
        }
        catch (MyException exception) {
            System.out.println("Negative side is detected");
        }
    }

    @Test
    void sidesSumTest () throws MyException {
        try {
            Triangle sideSumTriangle = new Triangle(1, 2, 4);
        }
        catch (MyException exception) {
            System.out.println("Impossible triangle, sum of 2 sides is less than the third side");
        }
    }
}
