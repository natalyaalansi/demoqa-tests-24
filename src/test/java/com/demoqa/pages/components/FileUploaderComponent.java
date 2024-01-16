package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class FileUploaderComponent {
    public void uploadFile(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
    }
}
