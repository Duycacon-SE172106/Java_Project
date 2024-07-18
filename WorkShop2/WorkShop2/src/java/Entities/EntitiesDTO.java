/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author chinl
 */
public class EntitiesDTO {
    private String mobileId;
    private String description;
    private float price;
    private String mobileName;
    private int yearOfProduct;
    private int quantity;
    private boolean notSale;

    public EntitiesDTO() {
    }

    public EntitiesDTO(String mobileId, String description, float price, String mobileName, int yearOfProduct, int quantity, boolean notSale) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduct = yearOfProduct;
        this.quantity = quantity;
        this.notSale = notSale;
    }

    public EntitiesDTO(String mobileId, String description, float price, String mobileName, int yearOfProduct, int quantity) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.yearOfProduct = yearOfProduct;
        this.quantity = quantity;
    }
    

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getYearOfProduct() {
        return yearOfProduct;
    }

    public void setYearOfProduct(int yearOfProduct) {
        this.yearOfProduct = yearOfProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isNotSale() {
        return notSale;
    }

    public void setNotSale(boolean notSale) {
        this.notSale = notSale;
    }

    

    
}
