package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("oleg@oleg.leg");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1970");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/test.png ");
        $("#currentAddress").setValue("gorgasali");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Oleg"));
        $(".table-responsive").shouldHave(text("Petrov"));
        $(".table-responsive").shouldHave(text("oleg@oleg.leg"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("0123456789"));
        $(".table-responsive").shouldHave(text("gorgasali"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("test.png"));
        $(".table-responsive").shouldHave(text("30 December,1970"));
    }
}