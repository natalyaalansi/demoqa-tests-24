package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.testdata.TestData;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void successfulRegistrationAllFields() {

        registrationPage.openPage()
                .checkFormTitle(testData.formTitle)
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
    }

    @Test
    void successfulRegistrationRequiredFields() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phone)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .submit();


        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear);
    }

    @Test
    void failedRegistrationBlankFields() {

        registrationPage.openPage()
                .submit();


        registrationPage.checkAbsenceModalWindow();
    }

}