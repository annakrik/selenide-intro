package org.an.selenideintro_xpath_version;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {
    @Test
    void completeTasks(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']//*[.//text()='b']//*[contains(concat(' ',normalize-space(@class),' '),' toggle ')]")).click();
        elements(byXpath("//*[@id='todo-list']//*[contains(concat(' ',normalize-space(@class),' '),' completed ')]")).shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']//li[not(contains(@class, 'completed'))]")).shouldHave(exactTexts("a", "c"));
    }
}
