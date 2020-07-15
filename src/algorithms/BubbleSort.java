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
// https://www.geeksforgeeks.org/bubble-sort/
public class BubbleSort {
    //type = 0, Size
    //type = 1, Color
    //type = 2, Fabric

    //order = 0 , ASC
    //order = 1, DESC
    public List<Tshirt> sort(List<Tshirt> arr, int n, byte order, byte type) {
        int i, j;
        Tshirt temp;
        boolean swapped;

        switch (type) {

            case 0://Size
                for (i = 0; i < n - 1; i++) {
                    swapped = false;
                    for (j = 0; j < n - i - 1; j++) {
                        boolean condition = false;
                        switch (order) {
                            case 0://ASC
                                condition = arr.get(j).getSize().ordinal() > arr.get(j + 1).getSize().ordinal();
                                break;
                            case 1://DESC
                                condition = arr.get(j).getSize().ordinal() < arr.get(j + 1).getSize().ordinal();
                                break;
                        }
                        if (condition) {
                            // swap arr.get(j) and arr.get(j+1) 
                            temp = arr.get(j);
                            arr.set(j, arr.get(j + 1));
                            arr.set(j + 1, temp);
                            swapped = true;
                        }
                    }

                    // IF no two elements were  
                    // swapped by inner loop, then break 
                    if (swapped == false) {
                        break;
                    }
                }
                break;

            case 1://Color
                for (i = 0; i < n - 1; i++) {
                    swapped = false;
                    for (j = 0; j < n - i - 1; j++) {
                        boolean condition = false;
                        switch (order) {
                            case 0://ASC
                                condition = arr.get(j).getColor().ordinal() > arr.get(j + 1).getColor().ordinal();
                                break;
                            case 1://DESC
                                condition = arr.get(j).getColor().ordinal() < arr.get(j + 1).getColor().ordinal();
                                break;
                        }
                        if (condition) {
                            // swap arr.get(j) and arr.get(j+1)
                            temp = arr.get(j);
                            arr.set(j, arr.get(j + 1));
                            arr.set(j + 1, temp);
                            swapped = true;
                        }
                    }

                    // IF no two elements were  
                    // swapped by inner loop, then break 
                    if (swapped == false) {
                        break;
                    }
                }
                break;

            case 2://Fabric
                for (i = 0; i < n - 1; i++) {
                    swapped = false;
                    for (j = 0; j < n - i - 1; j++) {
                        boolean condition = false;
                        switch (order) {
                            case 0://ASC
                                condition = arr.get(j).getFabric().ordinal() > arr.get(j + 1).getFabric().ordinal();
                                break;
                            case 1://DESC
                                condition = arr.get(j).getFabric().ordinal() < arr.get(j + 1).getFabric().ordinal();
                                break;
                        }
                        if (condition) {
                            // swap arr.get(j) and arr.get(j+1)
                            temp = arr.get(j);
                            arr.set(j, arr.get(j + 1));
                            arr.set(j + 1, temp);
                            swapped = true;
                        }
                    }

                    // IF no two elements were  
                    // swapped by inner loop, then break 
                    if (swapped == false) {
                        break;
                    }
                }
                break;
        }

        return arr;
    }

}
