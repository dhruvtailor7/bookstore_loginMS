//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.coviam.t3login.dto;

public class CartUpdateDTO {
    private String cartId;
    private String customerId;

    public CartUpdateDTO() {
    }

    public String getCartId() {
        return this.cartId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String toString() {
        return "CartUpdateDTO(cartId=" + this.getCartId() + ", customerId=" + this.getCustomerId() + ")";
    }
}
