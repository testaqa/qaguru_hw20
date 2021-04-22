package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class AppiumTests extends BaseTest{

    @Test
    void searchWikiOnEmulator() {

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Beer");

        $$(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).shouldHave(sizeGreaterThan(0));
        $(MobileBy.id("org.wikipedia.alpha:id/search_results_list"))
                .$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                .shouldHave(text("Alcoholic drink made from fermented cereal grains"));
    }
}