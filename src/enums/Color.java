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
public enum Color {

    RED(1),
    ORANGE(1),
    YELLOW(1),
    GREEN(1),
    BLUE(1),
    INDIGO(2),
    VIOLET(3);

    private int price;

    private Color(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
