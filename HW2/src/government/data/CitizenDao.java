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
public interface CitizenDao
{

    public void addCitizen(Citizen citizen , Session session);

    public void updateCitizen(int id , Citizen citizen , Session session);

    public void deleteCitizen(int id , Session session);

    public Citizen getCitizen(int id , Session session);

    public void getAllCitizens(Session session);
}
