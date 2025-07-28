package tests;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import static base.Base.driver;

public class LoginUsingSSH extends Base{
    @Test
    public void loginUsingSSOTest() {
        LoginPage loginPage = new LoginPage(driver);

        // Call the loginUsingSSO method and store the result
        boolean isLoginSuccessful = loginPage.loginUsingSSO();

        // Validate the outcome with a normal assertion
        Assert.assertTrue(isLoginSuccessful, "Login using SSO failed!");

        // Log the outcome
        if (isLoginSuccessful) {
            System.out.println("Login using SSO test passed.");
        } else {
            System.err.println("Login using SSO test failed.");
        }
    }
}
