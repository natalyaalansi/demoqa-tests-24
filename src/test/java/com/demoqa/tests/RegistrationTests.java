package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationAllFields() {

        registrationPage.openPage()
                .checkFormTitle("Student Registration Form")
                .setFirstName("Oleg")
                .setLastName("Petrov")
                .setEmail("oleg@oleg.leg")
                .setGender("Male")
                .setPhoneNumber("0123456789")
                .setDateOfBirth("30", "December", "1970")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .uploadPicture("img/test.png")
                .setCurrentAddress("gorgasali")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();

        registrationPage.checkAppearanceModalWindow()
                .checkTitleModalWindow("Thanks for submitting the form")
                .checkResult("Student Name", "Oleg Petrov")
                .checkResult("Student Email", "oleg@oleg.leg")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "30 December,1970")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "test.png")
                .checkResult("Address", "gorgasali")
                .checkResult("State and City", "Haryana Karnal");
    }

    @Test
    void successfulRegistrationRequiredFields() {

        registrationPage.openPage()
                .setFirstName("Oleg")
                .setLastName("Petrov")
                .setGender("Other")
                .setPhoneNumber("9876543219")
                .setDateOfBirth("24", "July", "1990")
                .submit();


        registrationPage.checkResult("Student Name", "Oleg Petrov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9876543219")
                .checkResult("Date of Birth", "24 July,1990");
    }

    @Test
    void failedRegistrationBlankFields() {

        registrationPage.openPage()
                .submit();


        registrationPage.checkAbsenceModalWindow();
    }

}