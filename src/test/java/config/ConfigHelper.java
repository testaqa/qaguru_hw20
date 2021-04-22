package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    private static MobileConfig getMobileConfig() {
        return ConfigFactory.create(MobileConfig.class);
    }

    public static String getBrowserstackUser() {
        return getMobileConfig().browserstackUser();
    }

    public static String getBrowserstackKey() {
        return getMobileConfig().browserstackKey();
    }

    public static String getSelenoidUrl() {
        return getMobileConfig().selenoidUrl();
    }
}