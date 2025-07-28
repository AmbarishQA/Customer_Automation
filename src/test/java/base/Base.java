package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;

public class Base {

    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Ambarish Raghav\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        System.out.println("Appium server started at: " + service.getUrl());

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:deviceName", "Redmi Note 13 Pro)");
        cap.setCapability("appium:platformVersion", "15");
        cap.setCapability("appium:udid", "9bf62014");
        cap.setCapability("appium:automationName", "UiAutomator2");
//        cap.setCapability("appium:appPackage", "com.gokhana.customer");
//        cap.setCapability("appium:appActivity", "com.gokhana.customer.MainActivity");
        cap.setCapability("appium:autoGrantPermissions", true);

        File f = new File("src/test/resource");
        File fs = new File(f, "Gk_Cust_v3.0.3_477_preprod.apk");
        cap.setCapability("appium:app", fs.getAbsolutePath());

        driver = new AndroidDriver(service.getUrl(), cap);

    }

//public void hideKeyboardIfVisible() {
//    try {
//        driver.hideKeyboard();  // Will throw if keyboard is not present
//        System.out.println("Keyboard hidden.");
//    } catch (Exception e) {
//        System.out.println("Keyboard was not open. Skipping hide.");
//    }
//}
//@Test
//public void launchAppTest() {
//    System.out.println("App launched successfully!");
//}


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test session ended.");
        }
        if (service != null) {
            service.stop();
            System.out.println("Test server ended.");
        }
    }
}
