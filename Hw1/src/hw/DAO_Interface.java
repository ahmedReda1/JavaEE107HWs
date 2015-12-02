/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ahmedreda
 */
public interface DAO_Interface
{

    public List<Product> getAllProducts();

    public Product getProductById(int id);

    public Product getProductByName(String name);

    public void deleteProductById(int id);

    public void deleteProductByName(String name);

    public void InsertProduct(String name, double price);

    public void updateProductById(int id, String name, double price);

    public void bulkInsert(Map<String, Double> map);

}
