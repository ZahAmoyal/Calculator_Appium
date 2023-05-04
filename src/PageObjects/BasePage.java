package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    static AndroidDriver driver;

    // constructor
    public BasePage(AndroidDriver driver) {
        this.driver =driver;
    }
// A function that receives an element and clicks on it
    public void clickOnElement(WebElement element){
        element.click();
    }
}
