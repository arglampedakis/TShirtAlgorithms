/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import enums.Color;
import enums.Fabric;
import enums.Size;
import paymentStrategy.PaymentStrategy;

/**
 *
 * @author glamb
 */
public class Tshirt {

    private Color color;
    private Size size;
    private Fabric fabric;
    private int totalPrice;
    private PaymentStrategy payment;

    public Tshirt(Color color, Size size, Fabric fabric) {
        this.color = color;
        this.size = size;
        this.fabric = fabric;
        this.totalPrice = color.getPrice() + size.getPrice() + fabric.getPrice();
    }

    //not in use, left it there from previous assignment.
    public void executeStrategy(PaymentStrategy payment) {
        this.setPayment(payment);
        this.payment.payWith(this.totalPrice);
    }

    @Override
    public String toString() {
        return "{ Size: " + size + ", Color: " + color + ", Fabric: " + fabric + " }";
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentStrategy getPayment() {
        return payment;
    }

    public void setPayment(PaymentStrategy payment) {
        this.payment = payment;
    }

}
