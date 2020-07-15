/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamp
 */
// https://www.netjstech.com/2019/01/bucket-sort-program-in-java.html
public class BucketSort {

    public List<Tshirt> sort(List<Tshirt> arr, int noOfBuckets, byte order, byte type) {
        // Create bucket array
        List<Tshirt>[] buckets = new List[noOfBuckets + 1];
        // initialiaze each position of the array with a LinkedList
        for (int i = 0; i <= noOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (Tshirt Tshirt : arr) {
            switch (order) {
                case 0://ASC
                    switch (type) {
                        case 0://Size
                            buckets[Tshirt.getSize().ordinal()].add(Tshirt);
                            break;
                        case 1://Color
                            buckets[Tshirt.getColor().ordinal()].add(Tshirt);
                            break;
                        case 2://Fabric
                            buckets[Tshirt.getFabric().ordinal()].add(Tshirt);
                            break;
                    }
                    break;
                case 1://DESC
                    switch (type) {
                        case 0://Size
                            buckets[noOfBuckets - Tshirt.getSize().ordinal()].add(Tshirt);
                            break;
                        case 1://Color
                            buckets[noOfBuckets - Tshirt.getColor().ordinal()].add(Tshirt);
                            break;
                        case 2://Fabric
                            buckets[noOfBuckets - Tshirt.getFabric().ordinal()].add(Tshirt);
                            break;
                    }
                    break;
            }
        }

        //Merge buckets to get sorted array
        List<Tshirt> result = new ArrayList<>();
        for (List<Tshirt> bucket : buckets) { // iterate on every bucket
            for (Tshirt Tshirt : bucket) { // iterate List Tshirt on each bucket
                result.add(Tshirt);
            }
        }

        return result;
    }

}
