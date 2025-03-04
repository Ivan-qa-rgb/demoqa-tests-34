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

        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan@ivanov.com");
        $("#gender").setValue("gender-radio-1");
        $("#Mobile Number").setValue("7123456789");
        $("#data0fBirthInput").setValue("15 Mar 2010");
        $("#subjects-labelContainer").setValue("Biology");
        $("#subjects-label").setValue("hobbies-checkbox-1");
        $("#uploadPicture").setValue("0a7e446b8166536d1d74430d256da9f7_big");
        $("#Current Address").setValue("Shelton Street 75");
        $("#true").setValue("NCR");
        $("#true").setValue("Noida");
        $("#submit").click();


        $("#output").$("#name").shouldHave(text("Alex"));
        $("#output").$("#Email").shouldHave(text("alex@egorov.com"));
        $("#output").$("#currentAddress").shouldHave(text("Sone street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Another street 3"));
    }
}
