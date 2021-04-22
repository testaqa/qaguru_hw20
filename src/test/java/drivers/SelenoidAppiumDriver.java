package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SelenoidAppiumDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Selenoid options
        caps.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));

        // Install and interact with app
        caps.setCapability("app", getAppUrl());
        caps.setCapability("appPackage", "org.wikipedia.alpha");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        // Other capabilities
        caps.setCapability("automationName", "Appium");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("deviceName", "android");

        caps.setCapability("locale", "en");
        caps.setCapability("language", "en");

        return new AndroidDriver<>(getUrl(), caps);
    }

    public static URL getUrl() {
        try {
            return new URL(ConfigHelper.getSelenoidUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static URL getAppUrl() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/untagged-4569c2d6deed0da37be2/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

