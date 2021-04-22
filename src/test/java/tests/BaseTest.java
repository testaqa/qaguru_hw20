package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackAppiumDriver;
import drivers.DeviceAppiumDriver;
import drivers.EmulatorAppiumDriver;
import drivers.SelenoidAppiumDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void beforeAll() {

        String driverType = System.getProperty("mobile.driver");

        switch (driverType) {
            case ("emulator"):
                Configuration.browser = EmulatorAppiumDriver.class.getName();
                break;
            case ("device"):
                Configuration.browser = DeviceAppiumDriver.class.getName();
                break;
            case ("selenoid"):
                Configuration.browser = SelenoidAppiumDriver.class.getName();
                break;
            case ("browserstack"):
                Configuration.browser = BrowserstackAppiumDriver.class.getName();
                break;
            default:
                throw new IllegalArgumentException("Please set driver type!");
        }

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void startDriver() {
        open();
    }
}
