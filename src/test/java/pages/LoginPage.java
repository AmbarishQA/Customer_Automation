package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    public LoginPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = "//android.widget.Button[@content-desc='Food Courts']")
    public WebElement foodCourtsButton;

    @FindBy(xpath = "//android.widget.EditText")
    public WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.CheckBox")
    public WebElement termsCheckBox;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Get OTP']")
    public WebElement getOtpButton;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//android.widget.EditText")
    public java.util.List<WebElement> otpBoxes;
}
