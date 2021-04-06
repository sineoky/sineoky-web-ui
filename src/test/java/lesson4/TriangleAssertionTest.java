package lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleAssertionTest {
    private Triangle myTriangle1 = new Triangle(1,2,3);
    private Triangle myTriangle2 = new Triangle(9,9,9);
    private Triangle myTriangle3 = new Triangle(5,7,3);
    private Triangle myTriangle4 = new Triangle(4,6,7);

    @Nested
    @DisplayName("Triangle Tests")
    class CanCalculate {

        @Test
        @Tag("Test1")
        void canCalc1() {
            assertTrue(myTriangle4.countArea() == 12);
            assertEquals(12, myTriangle4.countArea());
            //должно быть 12
        }

        @Test
        @Tag("Test2")
        void canCalc2() {
            assertEquals(6, myTriangle3.countArea());
        }
        //должно быть 6

        @Test
        @Tag("Test3")
        void canCalc3(){
            assertFalse(myTriangle2.countArea() == 36);
            // должно быть 35
        }

       @Test
       @Tag("Test4")
       void canCalc4(){
            assertNotNull(myTriangle1.countArea()); // должна выдать exception, не создать
        }

    }
}
