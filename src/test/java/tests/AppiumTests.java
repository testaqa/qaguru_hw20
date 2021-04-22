package tests;

import config.ConfigHelper;
import drivers.DriverHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppiumTests extends BaseTest{

    @Test
    void searchWikiOnEmulator() {

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