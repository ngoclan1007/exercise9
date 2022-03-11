package com.company;

public class Product {

    private int id;
    private String nameProduct;
    private TypeProduct type;
    private int amount;
    private  long price;

    public Product(int id, String nameProduct, TypeProduct type, int amuont, long price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.type = type;
        this.amount = amuont;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public int getAmuont() {
        return amount;
    }

    public void setAmuont(int amuont) {
        this.amount = amuont;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "-" + nameProduct + "-" +type + "-"+ amount + "-"+price;
    }
}
