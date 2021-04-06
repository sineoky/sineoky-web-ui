package lesson4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TriangleAssumptionsTest {
    private Triangle triangle = new Triangle(9,9,9);

    //площадь=35
   @DisplayName("Triangle Tests")
    @Test
    void trueAssumption() {
        assumeTrue(triangle.countArea()> 34);
        assertEquals(35, triangle.countArea());

    }

   @Test
    void falseAssumption() {
        assumeFalse(triangle.countArea()< 35);
        assertEquals(35, triangle.countArea());

    }
}
