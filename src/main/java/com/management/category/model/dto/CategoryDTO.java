package com.management.category.model.dto;

public class CategoryDTO implements java.io.Serializable {
    private String CategoryCode;
    private String CategoryName;

    public CategoryDTO() {}

    public CategoryDTO(String categoryCode, String categoryName) {
        CategoryCode = categoryCode;
        CategoryName = categoryName;
    }

    public String getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        CategoryCode = categoryCode;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "CategoryCode='" + CategoryCode + '\'' +
                ", CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
