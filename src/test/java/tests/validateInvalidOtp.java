package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class validateInvalidOtp extends Base {
    @Test
    public void validateInvalidOtpTest() {
        LoginPage loginPage = new LoginPage(driver);

        // Call the invalidOtp method and store the result
        boolean isInvalidOtpDisplayed = loginPage.invalidOtp();

        // Validate the outcome with a normal assertion
        Assert.assertTrue(isInvalidOtpDisplayed, "Invalid OTP message not displayed!");

        // Log the outcome
        if (isInvalidOtpDisplayed) {
            System.out.println("Invalid OTP test passed.");
        } else {
            System.err.println("Invalid OTP test failed.");
        }
    }
}
