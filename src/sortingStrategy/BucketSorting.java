/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingStrategy;

import algorithms.BucketSort;
import enums.Order;
import enums.Type;
import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamb
 */
public class BucketSorting implements SortingStrategy {

    @Override
    public List<Tshirt> doSorting(List<Tshirt> arr, Order order, Type type) {
        byte or = (byte) order.ordinal();
        byte tp = (byte) type.ordinal();
        BucketSort bus = new BucketSort();
        //num of buckets is fixed for all types (7)
        arr = bus.sort(arr, 7, or, tp);
        return arr;
    }

}
