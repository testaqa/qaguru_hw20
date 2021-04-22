package tests;

import config.ConfigHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SelenoidTests {

    @Test
    void searchWikiOnEmulator() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Selenoid options
        caps.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));

        // Install and interact with app
        caps.setCapability("app", new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/untagged-4569c2d6deed0da37be2/app-alpha-universal-release.apk"));
        caps.setCapability("appPackage", "org.wikipedia.alpha");
        caps.setCapability("appActivity", "org.wikipedia.main.MainActivity");

        // Other capabilities
        caps.setCapability("automationName", "Appium");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");

        caps.setCapability("deviceName", "android");

        caps.setCapability("locale", "en");
        caps.setCapability("language", "en");

        // Initialize WebDriver
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL(ConfigHelper.getSelenoidUrl()), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Test steps

        // Click 'Skip' button
        driver.findElement(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();

        // Click search field
        driver.findElement(MobileBy.AccessibilityId("Search Wikipedia")).click();

        // Set search value
        driver.findElement(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Beer");

        // Verify several results is shown
        Assertions.assertTrue(driver.findElements(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).size() > 0);

        // Verify first result description
        Assertions.assertTrue(driver
                .findElements(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).get(0)
                .findElement(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description")).getText()
                .contains("Alcoholic drink made from fermented cereal grains"));

        // Quit driver
        driver.quit();
    }
}