/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vandita.pkg;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author vandita
 */
public class Cartt extends HttpServlet{
    
    String cartid, name, description, productid, image, totalprice, quantity, category;

    public String getCartid() {
        return cartid;
    }

    public void setCartid(String cartid) {
        this.cartid = cartid;
    }

    public Cartt(String cartid, String name, String description, String productid, String image, String totalprice, String quantity, String category) {
        this.cartid = cartid;
        this.name = name;
        this.description = description;
        this.productid = productid;
        this.image = image;
        this.totalprice = totalprice;
        this.quantity = quantity;
        this.category = category;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
}
