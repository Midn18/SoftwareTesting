import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
class CustomMathTest {
    @Parameterized.Parameters
    public static Collection sumValues() {
        return Arrays.asList(new Object[][]{{1, 1, 2}, {-1, 1, 0}, {10, 15, 25}});
    }

    @Parameterized.Parameters
    public static Collection division() {
        return Arrays.asList(new Object[][]{{2, 2, 1}, {3, 3, 1}, {4, 4, 1}});
    }

    @BeforeEach
    public void setUpClass() {
        System.out.println("setUpClass");
    }

    @AfterEach
    public void tearDownClass() {
        System.out.println("tearDownClass");
    }

    /**
     * Test of sum method, of class CustomMath.
     */
    @ParameterizedTest
    @MethodSource("sumValues")
    public void testSum(int x, int y, int expResult) {
        System.out.println("Verify sum method");
        int result = CustomMath.sum(x, y);
        Assertions.assertEquals(expResult, result);
        assertFalse(expResult != result);
    }

    @ParameterizedTest
    @MethodSource("division")
    public void testDivisionByZero(int x, int y, int expResult) {
        System.out.println("Verify division method");
        int result = CustomMath.division(x, y);
        assertEquals(expResult, result);
        assertTrue("y is not zero", y != 0);
    }
}