package org.an.selenideintro.helpers.selectors.xpath.dsl;

public class X{

    private String selector;

    public X(String selector) {
        this.selector = selector;
    }

    public static X all(){
        return new X("//*");
    }

    public X child(String element){
        selector += "/" + element;
        return this;
    }

    public X by(String predicate){
        selector += "[" + predicate + "]";
        return this;
    }

    public X descendant(){
        selector += "//*";
        return this;
    }

    public String x(){
        return selector;
    }

}
