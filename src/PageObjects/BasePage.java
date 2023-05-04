package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    static AndroidDriver driver;

    public BasePage(AndroidDriver driver) {
        this.driver =driver;
    }

    public void clickOnElement(WebElement element){
        element.click();
    }
}
