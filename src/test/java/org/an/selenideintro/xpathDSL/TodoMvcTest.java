package org.an.selenideintro.xpathDSL;

import org.an.selenideintro.helpers.selectors.xpath.dsl.X;
import org.an.selenideintro.helpers.selectors.xpath.dsl.Its;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest{
    @Test
    void completeTask(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath(X.all().by(Its.id("new-todo")).x())).setValue("a").pressEnter();
        element(byXpath(X.all().by(Its.id("new-todo")).x())).setValue("b").pressEnter();
        element(byXpath(X.all().by(Its.id("new-todo")).x())).setValue("c").pressEnter();

        elements(byXpath(X.all().by(Its.id("todo-list")).child("li").x()))
                .shouldHave(exactTexts("a", "b", "c"));

        element(byXpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.descendantWithText("b"))
                .descendant().by(Its.cssClass("toggle")).x()))
                .click();

        elements(byXpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.cssClass("completed")).x()))
                .shouldHave(exactTexts("b"));

        elements(byXpath(X.all().by(Its.id("todo-list"))
                .child("li").by(Its.not(Its.cssClass("completed")))
                .x())).shouldHave(exactTexts("a","c"));
    }
}