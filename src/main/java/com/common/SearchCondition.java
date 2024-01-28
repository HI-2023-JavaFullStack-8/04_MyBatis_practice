package com.common;

public class SearchCondition implements java.io.Serializable {

    private String option;
    private String value;
    private String productName;
    private String salesStore;
    private String newProduct;
    private String nonProduction;

    public SearchCondition() {}

    public SearchCondition(String option, String value) {
        this.option = option;
        this.value = value;
    }

    public SearchCondition(String option, String value, String productName, String salesStore, String newProduct, String nonProduction) {
        this.option = option;
        this.value = value;
        this.productName = productName;
        this.salesStore = salesStore;
        this.newProduct = newProduct;
        this.nonProduction = nonProduction;
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


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSalesStore() {
        return salesStore;
    }

    public void setSalesStore(String salesStore) {
        this.salesStore = salesStore;
    }

    public String getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(String newProduct) {
        this.newProduct = newProduct;
    }

    public String getNonProduction() {
        return nonProduction;
    }

    public void setNonProduction(String nonProduction) {
        this.nonProduction = nonProduction;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "option='" + option + '\'' +
                ", value='" + value + '\'' +
                ", productName='" + productName + '\'' +
                ", salesStore='" + salesStore + '\'' +
                ", newProduct='" + newProduct + '\'' +
                ", nonProduction='" + nonProduction + '\'' +
                '}';
    }
}

