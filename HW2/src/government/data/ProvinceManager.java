/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.data;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ahmedreda
 */
public class ProvinceManager implements ProvinceDao
{

    @Override
    public void addProvince(Province province, Session session)
    {
        session.beginTransaction();
        session.persist(province);
        session.getTransaction().commit();

    }

    @Override
    public void updateProvince(int id, Province newProvince, Session session)
    {
        session.beginTransaction();
        Province province = (Province) session.get(Province.class, id);
        province.setName(newProvince.getName());
        session.getTransaction().commit();

    }

    @Override
    public void deleteProvince(int id, Session session)
    {
        session.beginTransaction();
        Province c = (Province) session.get(Province.class, id);
        session.delete(c);
        session.getTransaction().commit();
    }

    @Override
    public Province getProvince(int id, Session session)
    {
        Province province = (Province) session.get(Province.class, id);
        return province;
    }

    @Override
    public Province getProvinceByName(String name, Session session)
    {

        String hql = "From Province";
        ProjectionList proList = Projections.projectionList();
        
        
        Criteria criteria = session.createCriteria(Province.class)
                .add(Restrictions.like("name", name,MatchMode.EXACT));

        Province province = (Province) criteria.uniqueResult();
        return province;

    }

    @Override
    public void getAllProvinces(Session session)
    {
        ArrayList<Province> provinces = null;
        Criteria criteria = session.createCriteria(Province.class);
        provinces = (ArrayList<Province>) criteria.list();

        provinces.stream().forEach((province) -> {
            System.out.println("Province name : " + province.getName());
        });
        
    }

}
