/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.service;

/**
 *
 * @author ahmedreda
 */
public interface ProvinceServiceDao
{

    public String addProvince(String name);

    public String updateProvince(String provinceName , String newName);

    public String deleteProvince(String provinceName);
    
    public void getAll();

}
