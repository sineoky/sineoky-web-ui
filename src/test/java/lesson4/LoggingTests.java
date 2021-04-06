package lesson4;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class LoggingTests {
    private  Triangle myTriangle1 = new Triangle(9,9,9);
    private static Logger logger = LoggerFactory.getLogger(TriangleAssertionTest.class);
    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }
        @Test
        @Tag("Test1")
        public void test1() {
            assertEquals(35, myTriangle1.countArea());
            logger.info("Test completed!");
        }

    @Test
    @Tag("Test2")
    void test2(){
        assertFalse(myTriangle1.countArea() == 36);
        // должно быть 35
    }


    @AfterEach
    public void tearDown(){
        logger.info("Test completed!");
    }

    @AfterAll
    static void afterAllTests() {
        logger.info("After all tests");

    }

    }

