package org.an.selenideintro.helpers;

public class XPath {

    public String findByCssClass(String className){
        String finalXPath = "contains(concat(' ',normalize-space(@class),' ')," + "'" + className + "'"+")";
        return finalXPath;
    }
}
