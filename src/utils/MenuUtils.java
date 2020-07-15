/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Tshirt;
import sortingStrategy.*;
import timePerformance.TimePerformance;

/**
 *
 * @author glamb
 */
public class MenuUtils {

    private final Scanner sc = new Scanner(System.in);
    private final Utils utils = new Utils();

    private List<Tshirt> generateTshirtsMenu() {

        System.out.println("How many T-shirts would you like to generate?");
        System.out.print("Type here: ");
        int numOfTshirts = sc.nextInt();

        List<Tshirt> result = utils.generateTshirts(numOfTshirts);
        return result;
    }

    private SortingStrategy chooseSortingStrategy() {

        boolean flag = true;
        do {
            System.out.println("Please selet a sorting algorithm: ");
            String choice = "";
            int i = 1;
            for (Algorithm a : Algorithm.values()) {
                System.out.println(i + ". " + a.name());
                i++;
            }

            System.out.println("Type here: ");
            choice = sc.next();

            switch (choice) {
                case "1":
                    return new QuickSorting();
                case "2":
                    return new BubbleSorting();
                case "3":
                    return new BucketSorting();
                default:
                    System.out.println("Wrong Option!");
                    break;
            }
        } while (flag);

        return null;
    }

    private Order chooseSortingOrder() {

        boolean flag = true;
        do {
            System.out.println("Please selet sorting order: ");
            String choice = "";
            int i = 1;
            for (Order o : Order.values()) {
                System.out.println(i + ". " + o.name());
                i++;
            }

            System.out.println("Type here: ");
            choice = sc.next();

            switch (choice) {
                case "1":
                    return Order.values()[0];// 0, ASC
                case "2":
                    return Order.values()[1];//1, DESC
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        } while (flag);

        return null;
    }

    private Type chooseSortingType() {

        boolean flag = true;
        do {
            System.out.println("Please selet sorting Type: ");
            String choice = "";
            int i = 1;
            for (Type t : Type.values()) {
                System.out.println(i + ". " + t.name());
                i++;
            }
            System.out.println(i + ". All");

            System.out.println("Type here: ");
            choice = sc.next();

            switch (choice) {
                case "1":
                    return Type.values()[0];//0, Size
                case "2":
                    return Type.values()[1];//1, Color
                case "3":
                    return Type.values()[2];//2, Fabric
                case "4":
                    return null; //sort by Size,Color,Fabric
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        } while (flag);

        return null;
    }

    public void menu() {

        List<Tshirt> tshirtList = generateTshirtsMenu();

        System.out.println("Unsorted list: ");
        utils.printTshirts(tshirtList);
        System.out.println("-------------------\n");

        SortingStrategy sortingStrategy = chooseSortingStrategy();// Quick, Bubble, Bucket

        Order order = chooseSortingOrder();// ASC, DESC

        Type type = chooseSortingType();// Size, Color, Fabric or Size&Color&Fabric
        // strategy.doSorting(tshirtList, Order.ASC, Type.Fabric);

        List<Tshirt> sortedTshirtList = new ArrayList<>();
        TimePerformance timePerformance;
        long lapse;
        if (type != null) {
            timePerformance = new TimePerformance();
            sortedTshirtList = sortingStrategy.doSorting(tshirtList, order, type);
            lapse = timePerformance.timeLapse();
            System.out.println("Time lapsed: " + lapse + " seconds.");
        } else {
            SortingUtils sortingUtils = new SortingUtils();
            timePerformance = new TimePerformance();
            sortedTshirtList = sortingUtils.doSortingPerType(tshirtList, order, sortingStrategy);
            lapse = timePerformance.timeLapse();
            System.out.println("Time lapsed: " + lapse + " seconds.");
        }
        utils.printTshirts(sortedTshirtList);
    }
}
