/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chinl
 */
public class Cart {
    private Map<String, EntitiesDTO> cart;

    public Cart() {
    }

    public Cart(Map<String, EntitiesDTO> cart) {
        this.cart = cart;
    }

    public Map<String, EntitiesDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, EntitiesDTO> cart) {
        this.cart = cart;
    }

    public boolean add(EntitiesDTO product) {
        boolean check = false;
        try {
            if(this.cart == null){
                this.cart = new HashMap<>();
            }
            if(this.cart.containsKey(product.getMobileId())){
                int currentQuantity = this.cart.get(product.getMobileId()).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(product.getMobileId(), product); 
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean edit(String id, int quantity) {
        boolean check = false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    EntitiesDTO product = this.cart.get(id);
                    product.setQuantity(quantity);
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
