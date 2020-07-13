package org.an.selenideintro;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTestXpath {
    @Test
    void completeTasks(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//input[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//input[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//input[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//ul[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//ul[@id='todo-list']//li[2]//input")).click();
        elements(byXpath("//ul[@id='todo-list']//li[contains(@class, 'completed')]")).shouldHave(exactTexts("b"));
        elements(byXpath("//ul[@id='todo-list']//li[not(contains(@class, 'completed'))]")).shouldHave(exactTexts("a", "c"));
    }
}
