/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.data;

import org.hibernate.Session;

/**
 *
 * @author ahmedreda
 */
public interface ProvinceDao
{

    public void addProvince(Province province, Session session);

    public void updateProvince(int id, Province province, Session session);

    public void deleteProvince(int id, Session session);

    public Province getProvince(int id, Session session);

    public Province getProvinceByName(String name, Session session);

    public void getAllProvinces(Session session);


}
