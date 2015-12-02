/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ahmedreda
 */
public class Hw
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ProductManager PM = new ProductManager();
        
        PM.InsertProduct("Tee", 2.35);
        
        PM.InsertProduct("football", 27.35);
        
        PM.InsertProduct("shoes", 17.35);
        
        PM.InsertProduct("pizza", 23.35);
        
        PM.InsertProduct("apartment", 200000.00);
        
        PM.InsertProduct("car", 26000.00);
        
        PM.deleteProductById(1);
        
        PM.deleteProductByName("car");
        
        Product pro = PM.getProductById(3);
        System.out.println("product with id 3 ->>>> name = " + pro.getName() + " && price = " + pro.getPrice());
        
        Map<String, Double> map = new HashMap<>();
        
        map.put("Ahmed", 23.1);
        map.put("Maged", 23.1);
        map.put("Samir", 23.1);
        map.put("Kamel", 23.1);
        map.put("Samer", 23.1);
        PM.bulkInsert(map);
    
        List<Product> ls = new ArrayList<>();
        
        ls = PM.getAllProducts();
        for (Product l : ls) {
            System.out.println(" name = "+l.getName()+"-> price = "+l.getPrice());
        }
        
    }

}
