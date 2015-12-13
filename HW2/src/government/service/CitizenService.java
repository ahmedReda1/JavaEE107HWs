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

/**
 *
 * @author ahmedreda
 */
public class CitizenService implements CitizenServiceDao
{

    @Override
    public String addCitizen(String name, String age, String provinceName)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        Province p = PM.getProvinceByName(provinceName, session);
        // if province does not exist in database
        if (p == null) {
            PM.addProvince(new Province(provinceName), session);
            p = PM.getProvinceByName(provinceName, session);
        }

        Citizen newCitizen;
        newCitizen = new Citizen(p, name, Integer.parseInt(age));

        CM.addCitizen(newCitizen, session);

        session.close();
        SF.close();

        return "Entry has been saved Successfully !";
    }

    @Override
    public String updateCitizen(int id, String newName, String newAge, String provinceName)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        Citizen citizen = CM.getCitizen(id, session);

        if (newAge != null) {
            if (!(newAge.isEmpty())) {
                if (Integer.parseInt(newAge) > 0) {
                    citizen.setAge(Integer.parseInt(newAge));
                }
            }
        }

        if (newName != null && !newName.isEmpty()) {
            citizen.setName(newName);
        }

        if (provinceName != null && !provinceName.isEmpty()) {
            Province p = PM.getProvinceByName(provinceName, session);
            citizen.setProvince(p);
        }

        CM.updateCitizen(id, citizen, session);

        session.close();
        SF.close();

        return "Entry has been update Successfully !";
    }

    @Override
    public String deleteCitizen(int id)
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();

        CM.deleteCitizen(id, session);

        session.close();
        SF.close();

        return "Citizen has been terminated Successfully !";
    }

    public void getAll()
    {
        ProvinceManager PM = new ProvinceManager();
        CitizenManager CM = new CitizenManager();

        SessionFactory SF = new Configuration().configure().buildSessionFactory();
        Session session = SF.openSession();
        
        CM.getAllCitizens(session);

        session.close();
        SF.close();

    }

}
