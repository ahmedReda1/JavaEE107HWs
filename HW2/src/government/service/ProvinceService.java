/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.service;

import government.data.Citizen;
import government.data.CitizenManager;
import government.data.Province;
import government.data.ProvinceManager;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.ProvidedService;

/**
 *
 * @author ahmedreda
 */
public class ProvinceService implements ProvinceServiceDao
{

//    @Override
//    public String addProvince(String name, int age, String provinceName)
//    {
//        
//    }
    @Override
    public String addProvince(String name)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        Province province = new Province(name);
        PM.addProvince(province, session);

        session.close();
        SF.close();

        return "Entry has been saved Successfully !";

    }

    @Override
    public String updateProvince(String provinceName, String newName)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        Province p = PM.getProvinceByName(provinceName, session);
        p.setName(newName);
        PM.updateProvince(p.getId(), p, session);
        session.close();
        SF.close();

        return "Entry has been updated Successfully !";

    }

    @Override
    public String deleteProvince(String provinceName)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        Province p = PM.getProvinceByName(provinceName, session);
        PM.deleteProvince(p.getId(), session);
        
        session.close();
        SF.close();

        return "Entry has been deleted Successfully !";

    }

    @Override
    public void getAll()
    {
        ProvinceManager PM = new ProvinceManager();
        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        PM.getAllProvinces(session);
        
        session.close();
        SF.close();
        
    }

}
