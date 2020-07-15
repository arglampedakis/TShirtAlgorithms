/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author glamb
 */
public enum Size {

    XS(1),
    S(1),
    M(1),
    L(1),
    XL(1),
    XXL(2),
    XXXL(3);

    private int price;

    private Size(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
