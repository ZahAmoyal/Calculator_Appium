package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalculatorPage extends BasePage {

    WebElement zero = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_00"));
    WebElement one = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01"));
    WebElement two = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));
    WebElement three = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
    WebElement four = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_04"));
    WebElement five = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05"));
    WebElement six = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_06"));
    WebElement seven = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_07"));
    WebElement eight = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08"));
    WebElement nine = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_09"));
    WebElement point = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_dot"));
    WebElement minus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub"));
    WebElement plus = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
    WebElement division = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_div"));
    WebElement multiplication = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul"));
    WebElement clear = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear"));
    WebElement equal = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
    WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_tv_result"));

    public CalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    public WebElement theResultAfterTheCalculation(){
        return result;
    }

    public void clickZero() {
        clickOnElement(zero);
    }

    public void clickOne() {
        clickOnElement(one);
    }

    public void clickTwo() {
        clickOnElement(two);
    }

    public void clickThree() {
        clickOnElement(three);
    }

    public void clickFour() {
        clickOnElement(four);
    }

    public void clickFive() {
        clickOnElement(five);
    }

    public void clickSix() {
        clickOnElement(six);
    }

    public void clickSeven() {
        clickOnElement(seven);
    }

    public void clickEight() {
        clickOnElement(eight);
    }

    public void clickNine() {
        clickOnElement(nine);
    }

    public void clickPoint() {
        clickOnElement(point);
    }

    public void clickMinus() {
        clickOnElement(minus);
    }

    public void clickPlus() {
        clickOnElement(plus);
    }

    public void clickDivision() {
        clickOnElement(division);
    }

    public void clickMultiplication() {
        clickOnElement(multiplication);
    }

    public void clickClear() {
        clickOnElement(clear);

    }

    public void clickEqual() {
        clickOnElement(equal);
    }
}
