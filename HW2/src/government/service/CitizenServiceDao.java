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
public interface CitizenServiceDao
{

    public String addCitizen(String name , String age , String provinceName);

    public String updateCitizen(int id, String newName, String newAge, String provinceName);

    public String deleteCitizen(int id);

    public void getAll();

}
