package org.an.selenideintro.helpers;

public class XPath {

    public static String hasCssClass(String name){
        return "contains(" +
                "concat(' ',normalize-space(@class),' '),' " + name + " ')";
    }
}
