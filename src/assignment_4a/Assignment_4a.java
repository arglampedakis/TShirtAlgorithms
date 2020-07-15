/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4a;

import java.util.Scanner;
import utils.MenuUtils;

/**
 *
 * @author glamb
 */
public class Assignment_4a {

    private static final Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String exit = "";
        do {
            MenuUtils menu = new MenuUtils();
            menu.menu();
            
            System.out.print("To exit type \"e\" . To continue type anything else. ");
            exit = sc.next();
        } while (!exit.equalsIgnoreCase("E"));

    }

}
