/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import enums.Order;
import enums.Type;
import java.util.ArrayList;
import java.util.List;
import model.Tshirt;
import sortingStrategy.SortingStrategy;

/**
 *
 * @author glamb
 */
public class SortingUtils {

    public List<Tshirt> doSortingPerType(List<Tshirt> arr, Order order, SortingStrategy sortingStrategy) {
        List<Tshirt> shirtsBySize = sortingStrategy.doSorting(arr, order, Type.Size);
        int[] arrayOfSameSizeCounters = getArrayOfSameTypeCounters(shirtsBySize, Type.Size);
        List<List<Tshirt>> subLists = new ArrayList<>();
        fillInAListWithSublistsOfTshirsOfTheSameType(subLists,
                arrayOfSameSizeCounters, shirtsBySize, order);

        List<List<Tshirt>> subListsPart2 = new ArrayList<>();
        for (int i = 0; i < subLists.size(); i++) {
            List<Tshirt> shirtsByColor = sortingStrategy.doSorting(subLists.get(i), order, Type.Color);
            int[] arrayOfSameColorCounters = getArrayOfSameTypeCounters(shirtsByColor, Type.Color);
            fillInAListWithSublistsOfTshirsOfTheSameType(subListsPart2,
                    arrayOfSameColorCounters, shirtsByColor, order);
        }

        List<List<Tshirt>> subLists3 = new ArrayList<>();
        for (int i = 0; i < subListsPart2.size(); i++) {
            List<Tshirt> sortedByFabric = sortingStrategy.doSorting(subListsPart2.get(i), order, Type.Fabric);
            int[] arrayOfSameFabricCounters = getArrayOfSameTypeCounters(sortedByFabric, Type.Fabric);
            fillInAListWithSublistsOfTshirsOfTheSameType(subLists3,
                    arrayOfSameFabricCounters, sortedByFabric, order);
        }

        List<Tshirt> result = new ArrayList<>();
        for (List<Tshirt> list : subLists3) {
            for (Tshirt tshirt : list) {
                result.add(tshirt);
            }

        }
        return result;
    }

    private static class TStruct {

        public int start;
        public int end;
    }

    private int[] getArrayOfSameTypeCounters(List<Tshirt> shirtsByType, Type type) {

        int[] arrayOfSameTypeCounters = new int[7];

        for (int j = 0; j < 7; j++) {
            arrayOfSameTypeCounters[j] = 0;
        }
        //counting how many tshirts of the same Type (Size, Color or Fabric) are, for each Type
        for (Tshirt tshirt : shirtsByType) {
            switch (type.ordinal()) {
                case 0:
                    arrayOfSameTypeCounters[tshirt.getSize().ordinal()]++;
                    break;
                case 1:
                    arrayOfSameTypeCounters[tshirt.getColor().ordinal()]++;
                    break;
                case 2:
                    arrayOfSameTypeCounters[tshirt.getFabric().ordinal()]++;
                    break;
            }
        }
        return arrayOfSameTypeCounters;
    }

    private void fillInAListWithSublistsOfTshirsOfTheSameType(List<List<Tshirt>> subLists,
            int[] arrayOfSameTypeCounters, List<Tshirt> shirtsByType, Order order) {

        boolean isASC = (Order.ASC.ordinal() == order.ordinal());

        TStruct[] allTypes = new TStruct[7];
        int counter = 0;
        if (isASC) {

            for (int k = 0; k < 7; k++) {
                allTypes[k] = new TStruct();
                if (arrayOfSameTypeCounters[k] == 0) {
                    allTypes[k].start = -1;
                    allTypes[k].end = -1;
                } else {
                    allTypes[k].start = counter;
                    allTypes[k].end = counter + arrayOfSameTypeCounters[k] - 1;
                    subLists.add(shirtsByType.subList(allTypes[k].start, allTypes[k].end + 1));
                }
                counter += arrayOfSameTypeCounters[k];
            }
        } else {
            for (int k = 6; k >= 0; k--) {
                allTypes[k] = new TStruct();
                if (arrayOfSameTypeCounters[k] == 0) {
                    allTypes[k].start = -1;
                    allTypes[k].end = -1;
                } else {
                    allTypes[k].start = counter;
                    allTypes[k].end = counter + arrayOfSameTypeCounters[k] - 1;
                    subLists.add(shirtsByType.subList(allTypes[k].start, allTypes[k].end + 1));
                }
                counter += arrayOfSameTypeCounters[k];
            }
        }
    }

}
