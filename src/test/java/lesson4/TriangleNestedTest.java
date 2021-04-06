package lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleNestedTest {
    private Triangle triangle1 = new Triangle(6,7,4);
    private Triangle triangle2 = new Triangle(5,7,4);
    private Triangle triangle3 = new Triangle(9,9,9);
    private Triangle triangle4 = new Triangle(1,2,3);

    @Nested
    @DisplayName("Triangle Tests")
    class CanCalculate {

        @Test
        @Tag("Test1")
        void canCalc1() {
            assertTrue(triangle1.countArea() == 12);
            assertEquals(12, triangle1.countArea());
            //должно быть 12
        }

        @Test
        @Tag("Test2")
        void canCalc2() {
            assertEquals(10, triangle2.countArea());
        }
        //должно быть 10

        @Test
        @Tag("Test3")
        void canCalc3(){
            assertFalse(triangle3.countArea()==38); // должно быть 35
        }

        @Test
        @Tag("Test4")
        void canCalc4(){
            assertNotNull(triangle4.countArea()); // должна выдать exception, не создать
        }

    }
}
