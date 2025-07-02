package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;

public class Base {

    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;

    @BeforeClass
    public void setUp() throws Exception {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\<YOUR_USERNAME>\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "AndroidDevice");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("udid", "HA1ZBR5F"); // replace with your device UDID
        cap.setCapability("appPackage", "com.gokhana.customer");
        cap.setCapability("appActivity", "com.gokhana.customer.MainActivity");
        cap.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
    }
}