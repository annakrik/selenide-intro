package org.an.selenideintro.xpathrefactoring;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.elements;

public class TodoMvcTest {
    @Test
    void completeTask(){
        open("http://todomvc.com/examples/emberjs/");

        element(byXpath("//*[@id='new-todo']")).setValue("a").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("b").pressEnter();
        element(byXpath("//*[@id='new-todo']")).setValue("c").pressEnter();
        elements(byXpath("//*[@id='todo-list']//li")).shouldHave(exactTexts("a", "b", "c"));

        element(byXpath("//*[@id='todo-list']"
                +"//li[.//text()='b']//*["+findByCssClass(false)+"]"))
                .click();
        elements(byXpath("//*[@id='todo-list']"
                +"//li["+findByCssClass(true)+"]"))
                .shouldHave(exactTexts("b"));
        elements(byXpath("//*[@id='todo-list']"
                +"//li[not("+findByCssClass(true)+")]"))
                .shouldHave(exactTexts("a", "c"));
    }

    String findByCssClass(boolean classCompleted){
        if (classCompleted){
            String findCompleted = "contains(concat(' ',normalize-space(@class),' '),' completed ')";
            return findCompleted;
        }
        String findToggle = "contains(concat(' ',normalize-space(@class),' '),' toggle ')";
        return findToggle;
    }
}