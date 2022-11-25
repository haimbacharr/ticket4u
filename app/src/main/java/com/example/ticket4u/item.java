package com.example.ticket4u;

import java.util.Date;

public class item {
    String name; //keep
    String price; //delete
    String sold; //delete
    Number numberPrice;
    Boolean boolStatus; //(0 = available , 1 = sold)
    Date date;
    String notes;
    customer cus;
    admin adm;
    location loc;
    guest gue;


    public item(String itemName, String itemPrice, String itemSold) {
        this.name = itemName;
        this.price = itemPrice;
        this.sold = itemSold;
//        this.boolSold = itemSold;
//        this.numberPrice = itemPrice;
    }

    public item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public Number getNumberPrice() {
        return numberPrice;
    }

    public void setNumberPrice(Number numberPrice) {
        this.numberPrice = numberPrice;
    }

    public Boolean getBoolStatus() {
        return boolStatus;
    }

    public void setBoolStatus(Boolean boolStatus) {
        this.boolStatus = boolStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "item{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", sold='" + sold + '\'' +
                ", numberPrice=" + numberPrice +
                ", boolStatus=" + boolStatus +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                '}';
    }
}
