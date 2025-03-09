
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
        import static com.codeborne.selenide.files.DownloadActions.click;

public class Homework  {

    @BeforeAll
    static void configurationBrowser() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void textBoxHomeWork() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Birkin");
        $("#userEmail").setValue("Ivan@yandex.ru");
        $(byText("Other")).click();
        $("#userNumber").setValue("7123654789");
        $("#dateOfBirthInput").click();
        $x("//*[@class='react-datepicker__year-select']").selectOption("2000");
        $x("//*[@class='react-datepicker__month-select']").selectOption("March");
        $x("//*[@class='react-datepicker__day react-datepicker__day--020']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-2").parent().$(byText("Reading")).click();
        $(".form-control-file").uploadFromClasspath("eda.tiff");
        $("#currentAddress").setValue("My current address");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $x("//td[text()='Ivan Birkin']").shouldHave(text("Ivan Birkin"));
        $x("//td[text()='Ivan@yandex.ru']").shouldHave(text("Ivan@yandex.ru"));
        $x("//td[text()='Other']").shouldHave(text("Other"));
        $x("//td[text()='7123654789']").shouldHave(text("7123654789"));
        $x("//td[text()='20 March,2000']").shouldHave(text("20 March,2000"));
        $x("//td[text()='English']").shouldHave(text("English"));
        $x("//td[text()='Reading']").shouldHave(text("Reading"));
        $x("//td[text()='eda.tiff']").shouldHave(text("eda.tiff"));
        $x("//td[text()='My current address']").shouldHave(text("My current address"));
        $x("//td[text()='Haryana Panipat']").shouldHave(text("Haryana Panipat"));
    }
}