package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Sone street 1");
        $("#permanentAddress").setValue("Another street 3");
        $("#submit").click();


        $("#output").$("#name").shouldHave(text("Alex"));
        $("#output").$("#Email").shouldHave(text("alex@egorov.com"));
        $("#output").$("#currentAddress").shouldHave(text("Sone street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Another street 3"));
    }
}