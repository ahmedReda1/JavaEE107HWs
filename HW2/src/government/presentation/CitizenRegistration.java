/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.presentation;

import government.service.CitizenService;

/**
 *
 * @author ahmedreda
 */
public class CitizenRegistration
{

    public static void register(String name, String age, String provinceName)
    {
        CitizenService CS = new CitizenService();
        String result = CS.addCitizen(name, age, provinceName);
        System.out.println(result);

    }

    public static void update(int id, String name, String age, String provinceName)
    {
        CitizenService CS = new CitizenService();
        String result = CS.updateCitizen(id, name, age, provinceName);
        System.out.println(result);
    }

    public static void delete(int id)
    {
        CitizenService CS = new CitizenService();
        String result = CS.deleteCitizen(id);
        System.out.println(result);
    }
}
