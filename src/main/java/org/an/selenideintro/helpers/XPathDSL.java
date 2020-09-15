package org.an.selenideintro.helpers;

public class XPathDSL {

    public String selector;

    public static XPathDSL all(){
        XPathDSL xpath = new XPathDSL();
        xpath.selector = "//*";
        return xpath;
    }

    public XPathDSL hasCssClass(String name){
        selector += "["+"contains(" +
                "concat(' ',normalize-space(@class),' '),' " + name + " ')" + "]";
        return this;
    }

    public XPathDSL notHasCssClass(String name){
        selector += "[not(contains(concat(' ',normalize-space(@class), ' '), '" + name + "'))]";
        return this;
    }

    public XPathDSL child(String value){
        selector += "/" + value;
        return this;
    }

    public XPathDSL filterByDescendantWithText(String value){
        selector += "[.//text()='" + value + "']";
        return this;
    }

    public XPathDSL filterById(String value){
        selector += "[@id='" + value + "']";
        return this;
    }

    public XPathDSL descendant(){
        selector += "//*";
        return this;
    }

    public String getSelector(){
        return selector;
    }

}
