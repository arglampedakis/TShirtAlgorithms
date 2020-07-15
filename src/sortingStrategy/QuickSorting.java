/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingStrategy;

import algorithms.QuickSort;
import enums.Order;
import enums.Type;
import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamb
 */
public class QuickSorting implements SortingStrategy {

    @Override
    public List<Tshirt> doSorting(List<Tshirt> arr, Order order, Type type) {
        byte or = (byte) order.ordinal();
        byte tp = (byte) type.ordinal();
        int high = arr.size() - 1;
        QuickSort qs = new QuickSort();
        arr = qs.sort(arr, 0, high, or, tp);
        return arr;
    }

}
