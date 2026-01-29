package exercise2_1.testcases;

import exercise2_1.pages.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class CalculatorTest {
    CalculatorPage calc;
    SoftAssert softAssert;

    @BeforeSuite(groups = {"basic", "advanced"})
    public void beforeSuite() {
        System.out.println("Start");
    }

    @BeforeMethod(groups = {"basic", "advanced"})
    public void setUp() {
        calc = new CalculatorPage();
        softAssert = new SoftAssert();
    }

    @Test(groups = "basic")
    public void testAdd() {
        int result = calc.add(10, 20);
        Assert.assertEquals(result, 30, "Error Add method");
    }

    @Test(groups = "basic")
    public void testSubtract() {
        Assert.assertEquals(calc.subtract(50, 10), 40, "Error Subtract method");
    }

    @Test(groups = "advanced")
    public void testMultiplyAndCheckMultiple() {
        softAssert.assertEquals(calc.multiply(5, 5), 25, "Error Multiply method");
        softAssert.assertEquals(calc.multiply(0, 100), 0, "Error Multiply with zero");
        softAssert.assertAll();
    }

    @Test(groups = "basic")
    public void testDivide() {
        Assert.assertEquals(calc.divide(10, 2), 5.0, "Error Divide method");
    }

    @Test(groups = "advanced", expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(10, 0);
    }

    @AfterMethod(groups = {"basic", "advanced"})
    public void tearDown() {
        calc = null;
    }

    @AfterSuite(groups = {"basic", "advanced"})
    public void afterSuite() {
        System.out.println("End");
    }

}
