package tests;

import io.appium.java_client.MobileBy;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

public class AppiumTests extends BaseTest {

    @Test
    @Description("Verify welcome screens")
    void welcomeScreen() {

        step("Assert 1st screen text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia …in over 300 languages")));
        step("Click next button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Assert 2nd screen text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("New ways to explore")));
        step("Click next button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Assert 3d screen text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Reading lists with sync")));
        step("Click next button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Assert 4th screen text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Send anonymous data")));
        step("Assert Done button text", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).shouldHave(text("GET STARTED")));
        step("Click Done button", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click());

        step("Assert search field appeared", () ->
                $(AccessibilityId("Search Wikipedia")).shouldBe(visible));
    }

    @Test
    @Description("Verify text search")
    void searchWiki() {

        step("Click Skip welcome screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        });
        step("Set search value", () -> {
            $(AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("Beer");
        });

        step("Assert results", () -> {
            $$(MobileBy.id("org.wikipedia.alpha:id/search_results_list")).shouldHave(sizeGreaterThan(0));
            $(MobileBy.id("org.wikipedia.alpha:id/search_results_list"))
                    .$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_description"))
                    .shouldHave(text("Alcoholic drink made from fermented cereal grains"));
        });
    }
}