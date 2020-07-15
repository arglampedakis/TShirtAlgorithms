/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamp
 */
// https://www.geeksforgeeks.org/quick-sort/
public class QuickSort {

    int partition(List<Tshirt> arr, int low, int high, byte order, byte type) {
        int pivot = 0;
        int i = 0;
        //type = 0, Size
        //type = 1, Color
        //type = 2, Fabric
        switch (type) {
            case 0:
                //Size
                pivot = arr.get(high).getSize().ordinal();
                i = (low - 1); // index of smaller element 
                for (int j = low; j < high; j++) {
                    //order = 0 , ASC
                    //order = 1, DESC

                    boolean condition = false;
                    switch (order) {
                        case 0:
                            //ASC
                            // If current element is smaller than the pivot 
                            condition = arr.get(j).getSize().ordinal() < pivot;
                            break;
                        case 1:
                            //DESC
                            // If current element is greater than the pivot 
                            condition = arr.get(j).getSize().ordinal() > pivot;
                            break;
                    }
                    if (condition) {
                        i++;

                        // swap arr.get(i) and arr.get(j) 
                        Tshirt temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                }
                break;
            case 1:
                //Color
                pivot = arr.get(high).getColor().ordinal();
                i = (low - 1); // index of smaller element 
                for (int j = low; j < high; j++) {
                    //order = 0 , ASC
                    //order = 1, DESC

                    boolean condition = false;
                    switch (order) {
                        case 0:
                            //ASC
                            // If current element is smaller than the pivot 
                            condition = arr.get(j).getColor().ordinal() < pivot;
                            break;
                        case 1:
                            //DESC
                            // If current element is greater than the pivot 
                            condition = arr.get(j).getColor().ordinal() > pivot;
                            break;
                    }
                    if (condition) {
                        i++;

                        // swap arr.get(i) and arr.get(j) 
                        Tshirt temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                }
                break;
            case 2:
                //Fabric
                pivot = arr.get(high).getFabric().ordinal();
                i = (low - 1); // index of smaller element 
                for (int j = low; j < high; j++) {
                    //order = 0 , ASC
                    //order = 1, DESC

                    boolean condition = false;
                    switch (order) {
                        case 0:
                            //ASC
                            // If current element is smaller than the pivot 
                            condition = arr.get(j).getFabric().ordinal() < pivot;
                            break;
                        case 1:
                            //DESC
                            // If current element is greater than the pivot 
                            condition = arr.get(j).getFabric().ordinal() > pivot;
                            break;
                    }
                    if (condition) {
                        i++;

                        // swap arr.get(i) and arr.get(j)  
                        Tshirt temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                }
                break;
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        Tshirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    /* The main function that implements QuickSort() 
      arr --> List to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public List<Tshirt> sort(List<Tshirt> arr, int low, int high, byte order, byte type) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, order, type);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1, order, type);
            sort(arr, pi + 1, high, order, type);
        }
        return arr;
    }

}
