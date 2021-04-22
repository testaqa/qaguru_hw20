package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    public static AndroidDriver<AndroidElement> getAppiumDriver() {
        String driverType = System.getProperty("mobile.driver");
        AndroidDriver<AndroidElement> driver;

        switch (driverType) {
            case ("emulator"):
                driver = new EmulatorAppiumDriver().createDriver();
                break;
            case ("device"):
                driver = new DeviceAppiumDriver().createDriver();
                break;
            case ("selenoid"):
                driver = new SelenoidAppiumDriver().createDriver();
                break;
            case ("browserstack"):
                driver = new BrowserstackAppiumDriver().createDriver();
                break;
            default:
                throw new IllegalArgumentException("Please set driver type!");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
