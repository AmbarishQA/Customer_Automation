package pages;

import base.Base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {

    private final AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        WebElement element = waitForElement(locator);
        element.click();
    }

    public boolean loginUsingSSO() {
        try {
            clickElement(By.xpath("//android.view.View[@content-desc='More Options, Double tap to explore more options']"));
            clickElement(By.xpath("//android.view.View[@content-desc='Login with SSO']"));

            WebElement emailField = waitForElement(By.xpath("//android.widget.EditText[@resource-id='i0116']"));
            emailField.sendKeys("test-gokhana@ecolab.com");

            clickElement(By.xpath("//android.widget.Button[@resource-id='idSIButton9']"));

            WebElement passwordField = waitForElement(By.xpath("//android.widget.EditText[@resource-id='i0118']"));
            passwordField.sendKeys("r%7,7/d@uA|,B/fapZ/2");

            clickElement(By.xpath("//android.widget.Button[@resource-id='idSIButton9']"));

            System.out.println("SSO login completed successfully.");
            return true;
        } catch (Exception e) {
            System.err.println("SSO login failed: " + e.getMessage());
            return false;
        }
    }

    public boolean loginThroughOtp() {
        try {
            clickElement(By.xpath("//android.view.View[@content-desc='More Options, Double tap to explore more options']"));

            WebElement phoneNumberField = waitForElement(By.xpath("//android.widget.EditText"));
            phoneNumberField.sendKeys("8072268345");

            Thread.sleep(8000);

            clickElement(By.xpath("//android.widget.CheckBox"));
            clickElement(By.xpath("//android.view.View[@content-desc='Get OTP']"));

            Thread.sleep(10000);

            clickElement(By.xpath("//android.widget.EditText"));

            WebElement otpField = waitForElement(By.xpath("//android.widget.EditText"));
            otpField.sendKeys("468671");

            System.out.println("OTP login completed successfully.");
            return true;
        } catch (Exception e) {
            System.err.println("OTP login failed: " + e.getMessage());
            return false;
        }
    }

    public boolean invalidOtp() {
        try {
            clickElement(By.xpath("//android.view.View[contains(@content-desc, 'More Options')]"));

            WebElement phoneNumberField = waitForElement(By.xpath("//android.widget.EditText"));
            phoneNumberField.sendKeys("8072268345");

            Thread.sleep(5000);

            clickElement(By.xpath("//android.widget.CheckBox"));
            clickElement(By.xpath("//android.view.View[@content-desc='Get OTP']"));

            Thread.sleep(5000);

            clickElement(By.xpath("//android.widget.EditText"));

            WebElement otpField = waitForElement(By.xpath("//android.widget.EditText"));
            otpField.sendKeys("123456");

            Thread.sleep(5000);

            WebElement invalidOtpMessage = waitForElement(By.xpath("//android.view.View[contains(@content-desc, 'Invalid OTP')]"));
            if (invalidOtpMessage.isDisplayed()) {
                System.out.println("Invalid OTP validation completed successfully.");
                return true;
            } else {
                System.err.println("The 'Invalid OTP' message was not displayed as expected.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Invalid OTP validation failed: " + e.getMessage());
            return false;
        }
    }
}
