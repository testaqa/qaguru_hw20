package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackAppiumDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        caps.setCapability("browserstack.user", ConfigHelper.getBrowserstackUser());
        caps.setCapability("browserstack.key", ConfigHelper.getBrowserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", "bs://a420fd60b30a1bca09ede4054444f5930885a82c");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 4");
        caps.setCapability("os_version", "11.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Browserstack Project");
        caps.setCapability("build", "Android Pixel4_v11");
        caps.setCapability("name", "Search wiki on browserstack test");

        // Initialize WebDriver
        return new AndroidDriver<>(getUrl(), caps);
    }

    public static URL getUrl() {
        try {
            return new URL("https://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
