package com.management.product.model.dto;

public class ProductDTO implements  java.io.Serializable{

    private String product_code;        //제품코드
    private String product_name;        //제품명
    private String origin_cost;         //원가
    private String release_date;        //출시일
    private String discount_rate;       //할인율
    private String sales_quantity;      //판매량

    private String stock_quantity;      //재고량
    private String category_code;       //분류코드
    private String production_status;   //생산여부

    public ProductDTO(){

    }

    public ProductDTO(String product_name, String origin_cost, String release_date, String discount_rate, String stock_quantity, String category_code) {

        this.product_name = product_name;
        this.origin_cost = origin_cost;
        this.release_date = release_date;
        this.discount_rate = discount_rate;
        this.sales_quantity = sales_quantity;
        this.stock_quantity = stock_quantity;
        this.category_code = category_code;
        this.production_status = production_status;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getOrigin_cost() {
        return origin_cost;
    }

    public void setOrigin_cost(String origin_cost) {
        this.origin_cost = origin_cost;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDiscount_rate() {
        return discount_rate;
    }

    public void setDiscount_rate(String discount_rate) {
        this.discount_rate = discount_rate;
    }

    public String getSales_quantity() {
        return sales_quantity;
    }

    public void setSales_quantity(String sales_quantity) {
        this.sales_quantity = sales_quantity;
    }

    public String getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(String stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getProduction_status() {
        return production_status;
    }

    public void setProduction_status(String production_status) {
        this.production_status = production_status;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "product_code='" + product_code + '\'' +
                ", product_name='" + product_name + '\'' +
                ", origin_cost='" + origin_cost + '\'' +
                ", release_date='" + release_date + '\'' +
                ", discount_rate='" + discount_rate + '\'' +
                ", sales_quantity='" + sales_quantity + '\'' +
                ", stock_quantity='" + stock_quantity + '\'' +
                ", category_code='" + category_code + '\'' +
                ", production_status='" + production_status + '\'' +
                '}';
    }

}
