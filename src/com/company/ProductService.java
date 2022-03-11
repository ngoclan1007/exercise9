package com.company;

import java.util.ArrayList;

import static com.company.TypeProduct.*;

public class ProductService {
    public ArrayList<Product> getListProduct(){
         ArrayList<Product> listProduct =  new ArrayList<>();
         Product p1 = new Product(1, "chổi", houseware, 4, 25000);
        Product p2 = new Product(2, "kệ", houseware, 6, 600000);
        Product p3 = new Product(3, "cam", food, 100, 30000);
        Product p4 = new Product(4, "táo", food, 80, 40000);
        Product p5 = new Product(5, "giày", TypeProduct.fashion, 20, 240000);
        Product p6 = new Product(6, "mũ", TypeProduct.fashion, 4, 200000);

        listProduct.add(p1);
        listProduct.add(p2);
        listProduct.add(p3);
        listProduct.add(p4);
        listProduct.add(p5);
        listProduct.add(p6);

        return listProduct;

//        for (Product p : listProduct){
//            System.out.println(p);
//        }

    }

    public void show(ArrayList<Product> list){
        for (Product p : list){
            System.out.println(p);
        }
    }

    public ArrayList<Product> findProductbyName(ArrayList<Product> list , String name){
    ArrayList<Product> fProductName = new ArrayList<>();
    for (Product p : list){
        if (p.getNameProduct().contains(name)){
            fProductName.add(p);
        }
    }
    return fProductName;
    }

    public ArrayList<Product> productsAmount5(ArrayList<Product> list, int soLuong){
        ArrayList<Product> fProductAmount5 = new ArrayList<>();
        for (Product p : list){
            if (p.getAmuont() < 5){
                fProductAmount5.add(p);
            }
        }
        return fProductAmount5;
    }
    public Product findProductbyId(ArrayList<Product> list, int id){
        Product findId = null;
        for (Product p : list){
            if (p.getId() == id){
                findId = p;
            }
        }
        return findId;
    }
    public boolean deleteProduct(ArrayList<Product> list, Product p){
           return list.remove(p);
    }

    public void updateAmount(Product p , int newAmount){
        p.setAmuont(newAmount);
    }

    public void updatePrice(Product p , long newPrice){
        p.setPrice(newPrice);
    }

    public boolean addNewProduct(ArrayList<Product> list, Product p){
        return list.add(p);
    }

    public ArrayList<Product> viewProduct50000(ArrayList<Product> list){
        ArrayList<Product> VproductByPrice50000= new ArrayList<>();
        for (Product p: list){
            if (p.getPrice()<50000){
                VproductByPrice50000.add(p);
            }
        }
        return VproductByPrice50000;
    }
    public ArrayList<Product> viewProduct100000(ArrayList<Product> list){
        ArrayList<Product> VproductByPrice100000= new ArrayList<>();
        for (Product p: list){
            if (p.getPrice()>=50000 && p.getPrice()<100000){
                VproductByPrice100000.add(p);
            }
        }
        return VproductByPrice100000;
    }
    public ArrayList<Product> viewProduct250000(ArrayList<Product> list){
        ArrayList<Product> VproductByPrice250000= new ArrayList<>();
        for (Product p: list){
            if (p.getPrice()>=100000 && p.getPrice()<250000){
                VproductByPrice250000.add(p);
            }
        }
        return VproductByPrice250000;
    }
    public ArrayList<Product> viewProductup250000(ArrayList<Product> list){
        ArrayList<Product> VproductByPriceup250000= new ArrayList<>();
        for (Product p: list){
            if (p.getPrice()>=250000){
                VproductByPriceup250000.add(p);
            }
        }
        return VproductByPriceup250000;
    }
    public ArrayList<Product> viewProductByTypeHouseware(ArrayList<Product> list){
        ArrayList<Product> VproductHouseware = new ArrayList<>();
        for (Product p : list){
            if (p.getType().equals(houseware)){
                VproductHouseware.add(p);
            }
        }
        return VproductHouseware;
    }
    public ArrayList<Product> viewProductByTypeFood(ArrayList<Product> list){
        ArrayList<Product> VproductFood = new ArrayList<>();
        for (Product p : list){
            if (p.getType().equals(food)){
                VproductFood.add(p);
            }
        }
        return VproductFood;
    }
    public ArrayList<Product> viewProductByTypeFashion(ArrayList<Product> list){
        ArrayList<Product> VproductFashion = new ArrayList<>();
        for (Product p : list){
            if (p.getType().equals(fashion)){
                VproductFashion.add(p);
            }
        }
        return VproductFashion;
    }

}
