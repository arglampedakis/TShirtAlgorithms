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
public enum Fabric {
    WOOL(20),
    COTTON(18),
    POLYESTER(10),
    RAYON(13),
    LINEN(15),
    CASHMERE(25),
    SILK(17);

    private int price;

    private Fabric(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
