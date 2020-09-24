package org.an.selenideintro.helpers.selectors.xpath.utils;

public class X {

    public static String hasCssClass(String name){
        return "contains(" +
                "concat(' ',normalize-space(@class),' '),' " + name + " ')";
    }
}
