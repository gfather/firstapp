package ru.geekbrains.servlet;

import java.math.BigDecimal;

public class Product {

    private Integer id = null;
    private String title = null;
    private BigDecimal cost = null;

    public Product(){}

    @Override
    public String toString() {
        return "id: " + this.id.toString() +  " title: "+ this.title + " cost:"+this.cost.toString();
    }

    public Product(Integer id, String title, BigDecimal cost) {
        this.title = title;
        this.id = id;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
