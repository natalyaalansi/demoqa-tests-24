package com.demoqa.testdata;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class TestData {
    static Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress(firstName.toLowerCase() + "." + lastName.toLowerCase());
    public String gender = getGender();
    public String phone = faker.phoneNumber().subscriberNumber(10);
    public String birthDay = String.format("%02d", faker.number().numberBetween(1, 28));
    public String birthMonth = getMonth();
    public String birthYear = String.valueOf(faker.number().numberBetween(1900, 2050));
    public String subject = getSubject();
    public String hobby = getHobbie();
    public String picturePath = "img/test.png";
    public String pictureName = "test.png";
    public String address = faker.address().fullAddress();
    public String city = getCity();
    public String state = getStateByCity(city);
    public String formTitle = "Student Registration Form";
    public String modalWindowtTitle = "Thanks for submitting the form";


    public String getMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getHobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public String getSubject() {
        return faker.options().option("Maths", "Arts", "English", "Biology", "Hindi", "Commerce");
    }

    public String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer");
    }

    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
}



