import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class helloTest {

    @Test

    void helloTest() {

        int result = hello.returner(3);

        Assertions.assertEquals(9, result);

    }




}
