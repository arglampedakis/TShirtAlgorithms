/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paymentStrategy;

/**
 *
 * @author glamb
 */
public class PayCash implements PaymentStrategy {

    @Override
    public void payWith(int totalPrice) {
        System.out.println(totalPrice + "$ paid via Cash");
    }

}
