package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public void checkResultTable(String field, String value) {
        $(".table-responsive").$(byText(field)).parent()
                .shouldHave(text(value));
    }
}
