package lesson4;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleRepeatedTest {
    private Triangle triangle1 = new Triangle(6,7,4);
    private Triangle triangle2 = new Triangle(9,9,9);

    @RepeatedTest(value = 3, name = " {currentRepeat} for {totalRepeat}")
    void canCalc1() {
        assertTrue(triangle2.countArea() == 35);
        assertEquals(35, triangle2.countArea());
        //ожидаем 35
    }

   @RepeatedTest(10)
    void canCalc() {
        assertTrue(triangle1.countArea() == 12);
        assertEquals(12, triangle1.countArea());
        //ожидаем 12
    }


}
