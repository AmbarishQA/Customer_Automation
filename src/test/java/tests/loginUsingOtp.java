package tests;
//
//import base.Base;
//import org.openqa.selenium.WebElement;
//import pages.LoginPage;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import java.time.Duration;
//import java.util.List;
//
//public class loginUsingOtp extends Base {
//
//    @Test
//    public void loginWithOtpAutoFetch() throws Exception {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        LoginPage loginPage = new LoginPage(driver);
//
//        wait.until(ExpectedConditions.elementToBeClickable(loginPage.foodCourtsButton)).click();
//        wait.until(ExpectedConditions.visibilityOf(loginPage.mobileNumberField)).sendKeys("8903314148");
//        loginPage.termsCheckBox.click();
//        loginPage.getOtpButton.click();
//
//        // Wait for OTP SMS to be received
//        Thread.sleep(5000); // wait for SMS to arrive
//
//        // Read OTP from SMS using adb
//        String adbCommand = "adb -s HA1ZBR5F shell content query --uri content://sms/inbox --projection body --sort_order \"date DESC\"";
//        Process process = Runtime.getRuntime().exec(adbCommand);
//        java.util.Scanner scanner = new java.util.Scanner(process.getInputStream());
//        String otp = null;
//
//        while (scanner.hasNextLine()) {
//            String line = scanner.nextLine();
//            if (line.contains("Your OTP is")) {
//                otp = line.replaceAll(".*?(\\d{6}).*", "$1");
//                break;
//            }
//        }
//
//        if (otp == null) throw new Exception("OTP not found in SMS");
//
//        // Enter OTP in fields
//        List<WebElement> boxes = loginPage.otpBoxes;
//        for (int i = 0; i < 6; i++) {
//            boxes.get(i).click();
//            boxes.get(i).sendKeys(Character.toString(otp.charAt(i)));
//        }
//
//        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton)).click();
//        System.out.println("Login completed with OTP: " + otp);
//    }
//}

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class loginUsingOtp extends Base {

    @Test
    public void loginUsingOtp() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        // Call the loginThroughOtp method and store the result
        boolean isLoginSuccessful = loginPage.loginThroughOtp();

        // Validate the outcome with a normal assertion
        Assert.assertTrue(isLoginSuccessful, "Login through OTP failed!");

        // Log the outcome
        if (isLoginSuccessful) {
            System.out.println("Login using OTP test passed.");
        } else {
            System.err.println("Login using OTP test failed.");
        }
    }
}
