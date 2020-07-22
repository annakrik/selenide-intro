package org.an.selenideintro.xpathrefactoring;

import org.an.selenideintro.helpers.XPath;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest extends XPath {
    @Test
    void completeTask(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']"
                +"//li[.//text()='b']//*["+findByCssClass(" toggle ")+"]"))
                .click();
        elements(byXpath("//*[@id='todo-list']"
                +"//li["+findByCssClass(" completed ")+"]"))
                .shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']"
                +"//li[not("+findByCssClass(" completed ")+")]"))
                .shouldHave(exactTexts("a", "c"));
    }
}