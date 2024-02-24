package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.FileUploaderComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private SelenideElement practiceFormWrapper = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalWindow = $(".modal-content"),
            modalWindowTitle = $("#example-modal-sizes-title-lg");


    CalendarComponent calendarComponent = new CalendarComponent();
    FileUploaderComponent fileUploaderComponent = new FileUploaderComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        SelenideElement bannerRoot = $(".fc-consent-root");
        if (bannerRoot.isDisplayed()) {
            bannerRoot.$(byText("Consent")).click();
        }
        return this;
    }

    public RegistrationPage checkFormTitle(String value) {
        practiceFormWrapper.shouldHave(text(value));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        fileUploaderComponent.uploadFile(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkResult(String field, String value) {
        resultTableComponent.checkResultTable(field, value);

        return this;
    }

    public RegistrationPage checkAppearanceModalWindow() {
        modalWindow.should(appear);

        return this;
    }

    public RegistrationPage checkTitleModalWindow(String value) {
        modalWindowTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkAbsenceModalWindow() {
        modalWindow.shouldNot(appear);

        return this;
    }


}
