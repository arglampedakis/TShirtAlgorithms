/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingStrategy;

import algorithms.BubbleSort;
import enums.Order;
import enums.Type;
import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamb
 */
public class BubbleSorting implements SortingStrategy {

    @Override
    public List<Tshirt> doSorting(List<Tshirt> arr, Order order, Type type) {
        byte or = (byte) order.ordinal();
        byte tp = (byte) type.ordinal();
        BubbleSort bs = new BubbleSort();
        arr = bs.sort(arr, arr.size(), or, tp);
        return arr;
    }

}
