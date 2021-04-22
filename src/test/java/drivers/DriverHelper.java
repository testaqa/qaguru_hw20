//package drivers;
//
//import io.appium.java_client.android.AndroidDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import java.util.concurrent.TimeUnit;
//
//public class DriverHelper {
//
//    public static WebDriver getDriver() {
//        String driverType = System.getProperty("mobile.driver");
//        WebDriver driver;
//
//        switch (driverType) {
//            case ("emulator"):
//                driver = new EmulatorAppiumDriver().createDriver(new DesiredCapabilities());
//                break;
//            case ("device"):
//                driver = new DeviceAppiumDriver().createDriver(new DesiredCapabilities());
//                break;
//            case ("selenoid"):
//                driver = new SelenoidAppiumDriver().createDriver(new DesiredCapabilities());
//                break;
//            case ("browserstack"):
//                driver = new BrowserstackAppiumDriver().createDriver(new DesiredCapabilities());
//                break;
//            default:
//                throw new IllegalArgumentException("Please set driver type!");
//        }
//
//        return driver;
//    }
//}
