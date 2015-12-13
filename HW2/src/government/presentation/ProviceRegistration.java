/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.presentation;

import government.service.ProvinceService;

/**
 *
 * @author ahmedreda
 */
public class ProviceRegistration
{

    public static void register(String provinceName)
    {
        ProvinceService PS = new ProvinceService();
        String result = PS.addProvince(provinceName);
        System.out.println(result);

    }

    public static void update(String provinceName , String newName)
    {
        ProvinceService PS = new ProvinceService();
        String result = PS.updateProvince(provinceName, newName);
        System.out.println(result);
    }

    public static void delete(String provinceName)
    {
        ProvinceService PS = new ProvinceService();
        String result = PS.deleteProvince(provinceName);
        System.out.println(result);
    }
}
