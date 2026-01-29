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
    @Parameters({"a","b"})
    public void testAdd(int a, int b) {
        int result = calc.add(a, b);
        Assert.assertEquals(result, a+b, "Error Add method");
    }

    @Test(groups = "basic")
    @Parameters({"a","b"})
    public void testSubtract(int a, int b) {
        Assert.assertEquals(calc.subtract(a, b), a-b, "Error Subtract method");
    }

    @Test(groups = "advanced")
    @Parameters({"a","b"})
    public void testMultiplyAndCheckMultiple(int a, int b) {
        softAssert.assertEquals(calc.multiply(a, b), a*b, "Error Multiply method");
        softAssert.assertEquals(calc.multiply(0, b), 0, "Error Multiply with zero");
        softAssert.assertAll();
    }

    @Test(groups = "basic")
    @Parameters({"a","b"})
    public void testDivide(int a, int b) {
        Assert.assertEquals(calc.divide(a, b), (double) a /b, "Error Divide method");
    }

    @Test(groups = "advanced", expectedExceptions = ArithmeticException.class)
    @Parameters({"a","b"})
    public void testDivideByZero(int a, int b) {
        calc.divide(a,b);
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
