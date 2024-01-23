package com.common;

public class SearchCondition implements  java.io.Serializable{

    private String option;              //검색 조건
    private String value;               //검색어

    public SearchCondition(){

    }

    public SearchCondition(String option, String value) {
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "option='" + option + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


}
