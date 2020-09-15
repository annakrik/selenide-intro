package org.an.selenideintro.xpathDSL;

import org.an.selenideintro.helpers.XPathDSL;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest{
    @Test
    void completeTask(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath(XPathDSL.all()
                .filterById("todo-list")
                .child("li")
                .filterByDescendantWithText("b")
                .descendant()
                .hasCssClass("toggle")
                .getSelector()))
                .click();

        elements(byXpath(XPathDSL.all()
                .filterById("todo-list")
                .child("li")
                .hasCssClass("completed")
                .getSelector()))
                .shouldHave(exactTexts("b"));

        elements(byXpath(XPathDSL.all()
                .filterById("todo-list")
                .child("li")
                .notHasCssClass("completed")
                .getSelector()))
                .shouldHave(exactTexts("a","c"));
    }
}