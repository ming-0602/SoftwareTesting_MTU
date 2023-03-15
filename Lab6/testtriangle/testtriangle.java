import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class testtriangle {

    Triangle triangle;

//    @BeforeAll
//    public void setup(){
//        triangle = new Triangle(3,2,1);
//    }

    @Test()
    public void checkside() throws IOException {
        triangle = new Triangle(10,10,10);
        assertEquals(10, triangle.getA());
        assertEquals(10, triangle.getB());
        assertEquals(10, triangle.getC());
    }

    @Test
    public void checktriangle() throws IOException{
        triangle = new Triangle(Double.parseDouble("a"),10,10);
        assertThrows(IllegalStateException.class);
    }
}
