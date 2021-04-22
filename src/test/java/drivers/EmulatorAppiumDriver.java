package drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorAppiumDriver {
    public AndroidDriver<AndroidElement> createDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Device id from 'adb devices'
        caps.setCapability("udid", "emulator-5556");

        // Install and interact with app
        caps.setCapability("app", new File("src/test/resources/apps/app-alpha-universal-release.apk").getAbsolutePath());
        caps.setCapability("appPackage", "org.wikipedia.alpha");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        // Other capabilities
        caps.setCapability("automationName", "Appium");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Pixel 4");

        caps.setCapability("locale", "en");
        caps.setCapability("language", "en");

        // Initialize WebDriver
        return new AndroidDriver<AndroidElement>(getUrl(), caps);
    }

    public static URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
