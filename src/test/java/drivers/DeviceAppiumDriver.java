package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceAppiumDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Device id from 'adb devices'
        caps.setCapability("udid", "b2cc95327d43");

        // Install and interact with app
        caps.setCapability("app", new File("src/test/resources/apps/app-alpha-universal-release.apk").getAbsolutePath());
        caps.setCapability("appPackage", "org.wikipedia.alpha");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        // Other capabilities
        caps.setCapability("automationName", "Appium");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0.1");
        caps.setCapability("deviceName", "Redmi 3S");

        // Initialize WebDriver
        return new AndroidDriver<>(getUrl(), caps);
    }

    public static URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
