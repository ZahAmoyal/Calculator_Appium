package Tests;

import PageObjects.CalculatorPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseTest {
    static AndroidDriver driver = null;
    static ExtentReports extent;
    static ExtentTest myTests;
    private static String readFilePath = "src/Data/NumbersAndActions.xml";
    private static String reportFilePath = "src/Data/NumbersAndActions.html";
    static String imagePath = "C:/Users/AsusX514/IdeaProjects/Calculetor_Appium/src/Data/Picture/";
    static String num1;
    static String num2;
    static CalculatorPage calculatorPage;

    public static void re(){
        calculatorPage=new CalculatorPage(driver);
    }


    @BeforeClass
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability("newCommandTimeout", 120);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        extent = new ExtentReports(reportFilePath);
        myTests = extent.startTest("ExtentDemo");
        re();
    }

    public void chars(char number) {
        switch (number) {
            case '0': {
                calculatorPage.clickZero();
                break;
            }
            case '1': {
                calculatorPage.clickOne();
                break;
            }
            case '2': {
                calculatorPage.clickTwo();
                break;
            }
            case '3': {
                calculatorPage.clickThree();
                break;
            }
            case '4': {
                calculatorPage.clickFour();
                break;
            }
            case '5': {
                calculatorPage.clickFive();
                break;
            }
            case '6': {
                calculatorPage.clickSix();
                break;
            }
            case '7': {
                calculatorPage.clickSeven();
                break;
            }
            case '8': {
                calculatorPage.clickEight();
                break;
            }
            case '9': {
                calculatorPage.clickNine();
                break;
            }
            case '.': {
                calculatorPage.clickPoint();
                break;
            }
        }
    }

    public void actions(String action) {
        switch (action) {
            case "+": {
                calculatorPage.clickPlus();
                break;
            }
            case "-": {
                calculatorPage.clickMinus();
                break;
            }
            case "/": {
                calculatorPage.clickDivision();
                break;
            }
            case "x": {
                calculatorPage.clickMultiplication();
                break;
            }
        }
    }

    public String readFromFile(String KeyData) throws Exception {
        File xmlFile = new File(readFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(KeyData).item(0).getTextContent();
    }


    public String commaReplacement(WebElement element) {
        String result = element.getText();
        result = result.replaceAll(",", "");
        return result;
    }


    public String takeScreenShot(String imagePath) {
        TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(imagePath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return imagePath + ".png";
    }

    public void splitNum(String number) {
        for (int i = 0; i < number.length(); i++) {
            chars(number.charAt(i));
        }
    }


    public void assertions(String excepted){
        try {
            assertEquals(excepted,commaReplacement(calculatorPage.theResultAfterTheCalculation()));
            myTests.log(LogStatus.PASS,myTests.addScreenCapture(takeScreenShot(imagePath+ "\\" + System.currentTimeMillis())));
        } catch (AssertionError e) {
            myTests.log(LogStatus.FAIL,e.getMessage(),myTests.addScreenCapture(takeScreenShot(imagePath + "\\" + System.currentTimeMillis())));
        }
    }
}
