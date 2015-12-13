/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.data;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author ahmedreda
 */
public class CitizenManager implements CitizenDao
{

    @Override
    public void addCitizen(Citizen citizen, Session session)
    {
        session.beginTransaction();
        session.persist(citizen);
        session.getTransaction().commit();

    }

    @Override
    public void updateCitizen(int id, Citizen newCitizen, Session session)
    {
        session.beginTransaction();
        Citizen citizen = (Citizen) session.get(Citizen.class, id);
        citizen.setName(newCitizen.getName());
        citizen.setAge(newCitizen.getAge());
        citizen.setProvince(newCitizen.getProvince());
        session.getTransaction().commit();

    }

    @Override
    public void deleteCitizen(int id, Session session)
    {
        session.beginTransaction();
        Citizen c = (Citizen) session.get(Citizen.class, id);
        session.delete(c);
        session.getTransaction().commit();
    }

    @Override
    public Citizen getCitizen(int id, Session session)
    {
        Citizen citizen = (Citizen) session.get(Citizen.class, id);
        return citizen;
    }

    /**
     *
     * @param session
     * @return
     */
    @Override
    public void getAllCitizens(Session session)
    {
        ArrayList<Citizen> citizens = null;
        Criteria criteria = session.createCriteria(Citizen.class);
        citizens = (ArrayList<Citizen>) criteria.list();

        citizens.stream().forEach((citizen) -> {
            System.out.println("name : " + citizen.getName() + "\tAge: " + citizen.getAge() + "\tProvince: " + citizen.getProvince().getName());
        });

    }

}
