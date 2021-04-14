package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/mobile.properties")
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface MobileConfig extends Config {

    @Config.Key("browserstack.user")
    String browserstackUser();

    @Config.Key("browserstack.key")
    String browserstackKey();
}