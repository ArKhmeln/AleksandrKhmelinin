package hw1;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends Base {

    @DataProvider
    public static Object[][] calcData() {
//        TODO Why you decide use this numbers?     fixed
        return new Object[][] {{8, -8, -64}, {3, 7, 21}, {-6, -7, 42}};
    }

    @Test(dataProvider = "calcData")
    public void multiplicationTest(long multiplicand, long factor, long expected) {
        long actual = calculator.mult(multiplicand, factor);
        //        TODO Is this operation necessary?     fixed
        assertEquals(actual, expected);
    }
}
