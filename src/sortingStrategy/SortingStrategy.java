/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingStrategy;

import enums.Order;
import enums.Type;
import java.util.List;
import model.Tshirt;

/**
 *
 * @author glamb
 */
public interface SortingStrategy {

    public List<Tshirt> doSorting(List<Tshirt> arr, Order order, Type type);

}
