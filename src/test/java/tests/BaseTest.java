package tests;

import drivers.DriverHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseTest {

    // Initialize WebDriver
    AndroidDriver<AndroidElement> driver = DriverHelper.getAppiumDriver();

}
