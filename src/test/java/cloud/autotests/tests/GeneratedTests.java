package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {

    Faker faker = new Faker();
    String email = faker.internet().emailAddress();

    @Test
    @Description("Check log in for new email")
    @DisplayName("Login for new email")
    void negativeLogin() {
        step("Open 'https://www.kinopoisk.ru/'", () -> {
            open("https://www.kinopoisk.ru/");
        });

        step("Open login form", () -> {
            $(byText("Войти")).click();
        });

        step("Verify login", () -> {
            $("#passp-field-login for new email").setValue(email).pressEnter();
            $(".passp-title").shouldHave(Condition.text("Мы отправили письмо с кодом на " + email+". Пожалуйста, введите его для завершения регистрации."));
        });
    }

    @Test
    @Description("Check opening and working standard search")
    @DisplayName("Standard search")
    void generatedTest() {
        step("Open 'https://www.kinopoisk.ru/'", () -> {
            open("https://www.kinopoisk.ru/");
        });

        step("Open search", () -> {
            $("input[placeholder='Фильмы, сериалы, персоны']").setValue("Триггер").pressEnter();
        });

        step("Verify search results", () -> {
            $("[data-id='1100777']").shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Check opening and working random search")
    @DisplayName("Random search")
    void checkSearch() {
        step("Open 'https://www.kinopoisk.ru/'", () -> {
            open("https://www.kinopoisk.ru/");
        });

        step("Open search", () -> {
            $("button[aria-label='submit']").click();
        });

        step("Verify search results", () -> {
            $("#genreListTitle").shouldHave(Condition.text("выберите жанры"));
            $("#countryListTitle").shouldHave(Condition.text("выберите страну"));
            $("#review_procentrange").shouldBe(Condition.visible);
            $(".button#search").click();
            $(".filmName").shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Check opening advanced search")
    @DisplayName("Advanced search")
    void checkAdvancedSearch() {
        step("Open 'https://www.kinopoisk.ru/'", () -> {
            open("https://www.kinopoisk.ru/");
        });

        step("Open search", () -> {
            $("a[aria-label='advanced-search']").click();
        });

        step("Verify search results", () -> {
            $(".moviename-big").$(".text-orange").shouldHave(Condition.text("Расширенный поиск")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Check title")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.kinopoisk.ru/'", () ->
            open("https://www.kinopoisk.ru/"));

        step("Page title should have text 'Кинопоиск. Все фильмы планеты.'", () -> {
            String expectedTitle = "Кинопоиск. Все фильмы планеты.";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Check logs for errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.kinopoisk..ru/'", () ->
            open("https://www.kinopoisk.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}