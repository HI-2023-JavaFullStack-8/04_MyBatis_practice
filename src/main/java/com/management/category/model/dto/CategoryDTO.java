package com.management.category.model.dto;

public class CategoryDTO implements  java.io.Serializable {

    private String category_code;
    private String category_name;
    private int category_count;

    public CategoryDTO(){

    }

    public CategoryDTO(String category_code, String category_name) {
        this.category_code = category_code;
        this.category_name = category_name;

    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_count() {
        return category_count;
    }

    public void setCategory_count(int category_count) {
        this.category_count = category_count;
    }

    @Override
    public String toString() {
        return "카테고리 코드 : " + category_code +
                " |  카테고리 이름 : " + category_name +
                " |  갯수 : " + category_count ;
    }

}
