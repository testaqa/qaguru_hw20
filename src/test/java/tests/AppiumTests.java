package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class AppiumTests extends BaseTest {

    @Test
    void welcomeScreen() {

        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();


        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();

        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldHave(text("GET STARTED"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();

        $(AccessibilityId("Search Wikipedia")).shouldBe(visible);
    }

    @Test
    void searchWiki() {

        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Beer");

        $$(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).shouldHave(sizeGreaterThan(0));
        $(MobileBy.id("org.wikipedia.alpha:id/search_results_list"))
                .$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                .shouldHave(text("Alcoholic drink made from fermented cereal grains"));
    }
}