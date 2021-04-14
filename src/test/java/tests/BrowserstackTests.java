package tests;

import config.ConfigHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserstackTests {

    @Test
    void searchWikiOnBrowserstack() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

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
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
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