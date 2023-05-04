package Tests;

import org.junit.*;
import org.junit.runners.MethodSorters;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CalculatorTest extends BaseTest {

    @Before
    public void read() throws Exception {
        num1 = readFromFile("num1");
        num2 = readFromFile("num2");
    }

    @Test
    public void Test01_plus() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        splitNum(num1);
        actions(readFromFile("addition"));
        splitNum(num2);
        assertions(readFromFile("expectedResultConnectionPperation"));
    }

    @Test
    public void Test02_subtraction() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        splitNum(num1);
        actions(readFromFile("subtraction"));
        splitNum(num2);
        assertions(readFromFile("subtractionOperationExpectedResult"));
    }

    @Test
    public void Test03_multiplication() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        splitNum(num1);
        actions(readFromFile("multiplicationOperation"));
        splitNum(num2);
        assertions(readFromFile("expectedResultMultiplicationOperation"));
    }


    @Test
    public void Test04_division() throws Exception {
        myTests = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        splitNum(num1);
        actions(readFromFile("division"));
        splitNum(num2);
        assertions(readFromFile("expectedResultDivisionOperation"));
    }

    @After
    public void clear() {
        calculatorPage.clickEqual();
        calculatorPage.clickClear();
        extent.endTest(myTests);
    }

    @AfterClass
    public static void finish() throws IOException {
        driver.quit();
        extent.flush();
        Desktop.getDesktop().browse(new File("C:\\Users\\AsusX514\\IdeaProjects\\Calculetor_Appium\\src\\Data\\NumbersAndActions.html").toURI());

    }
}