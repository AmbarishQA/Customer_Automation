//package org.example.listeners;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.example.setup.Setup;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import org.apache.commons.io.FileUtils;
//
//public class TestListener implements ITestListener {
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        Object testInstance = result.getInstance();
//
//        // Ensure the test class extends Setup to get the driver instance
//        if (testInstance instanceof Setup) {
//            AndroidDriver driver = ((Setup) testInstance).getDriver();
//
//            // Take a screenshot with the test method name
//            takeScreenshot(driver, result.getName());
//        }
//    }
//
//    private void takeScreenshot(AndroidDriver driver, String testName) {
//        try {
//            // Format the timestamp for unique filenames
//            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//            // Save to the screenshots folder
//            String destFile = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
//            FileUtils.copyFile(srcFile, new File(destFile));
//
//            System.out.println("Screenshot saved: " + destFile);
//        } catch (IOException e) {
//            System.err.println("Failed to capture screenshot: " + e.getMessage());
//        }
//    }
//}
