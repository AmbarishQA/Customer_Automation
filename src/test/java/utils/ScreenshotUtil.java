//package utils;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class ScreenshotUtil {
//
//    public static void takeScreenshot(AndroidDriver driver, String testName) {
//        try {
//            // Format the current date and time for unique screenshot names
//            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//
//            // Take a screenshot
//            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//            // Define the destination file path
//            String destFile = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";
//
//            // Copy the screenshot to the destination
//            FileUtils.copyFile(srcFile, new File(destFile));
//
//            System.out.println("Screenshot saved: " + destFile);
//        } catch (IOException e) {
//            System.err.println("Failed to take screenshot: " + e.getMessage());
//        }
//    }
//}
