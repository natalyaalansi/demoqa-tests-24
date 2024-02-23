package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.testdata.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("registration")
public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successfulRegistrationAllFields() {

        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill in all fields on the form", () -> {
            registrationPage.checkFormTitle(testData.formTitle)
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setEmail(testData.email)
                    .setGender(testData.gender)
                    .setPhoneNumber(testData.phone)
                    .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                    .setSubjects(testData.subject)
                    .setHobbies(testData.hobby)
                    .uploadPicture(testData.picturePath)
                    .setCurrentAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submit();
        });

        step("Verify results", () -> {
            registrationPage.checkAppearanceModalWindow()
                    .checkTitleModalWindow(testData.modalWindowtTitle)
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phone)
                    .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", testData.pictureName)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    void successfulRegistrationRequiredFields() {

        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill in the required fields on the form", () -> {
            registrationPage.setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setPhoneNumber(testData.phone)
                    .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                    .submit();
        });

        step("Verify results", () -> {
            registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phone)
                    .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear);
        });
    }

    @Test
    void failedRegistrationBlankFields() {

        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Submit form without filling in any fields", () -> {
            registrationPage.submit();
        });

        step("Check that there is no results window", () -> {
            registrationPage.checkAbsenceModalWindow();
        });
    }

}