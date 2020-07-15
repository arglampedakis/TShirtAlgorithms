/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import enums.Color;
import enums.Fabric;
import enums.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Tshirt;

/**
 *
 * @author glamb
 */
public class Utils {

    public List<Tshirt> generateTshirts(int count) {
        List<Tshirt> Tshirts = new ArrayList<Tshirt>();
        for (int i = 0; i < count; i++) {
            Tshirt e = new Tshirt((Color) generateRandomField(0), (Size) generateRandomField(2), (Fabric) generateRandomField(1));
            Tshirts.add(e);
        }
        return Tshirts;
    }

    private Object generateRandomField(int field) { // 0 = Color, 1 = Fabric, 2 = Size
        int k = generateNumber();

        switch (field) {
            case 0:
                Color c = Color.values()[k];
                return c;
            case 1:
                Fabric f = Fabric.values()[k];
                return f;
            case 2:
                Size s = Size.values()[k];
                return s;
            default:
                return 0;
        }

    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(7);
    }

    public void printTshirts(List<Tshirt> list) {
        int i = 1;
        for (Tshirt Tshirt : list) {
            System.out.println(i + ". " + Tshirt);
            i++;
        }
    }
}
