/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.presentation;

import government.service.CitizenService;
import government.service.ProvinceService;

/**
 *
 * @author ahmedreda
 */
public class Report
{

    public static void reportData()
    {
        CitizenService CS = new CitizenService();
        CS.getAll();
        ProvinceService PS = new ProvinceService();
        PS.getAll();
    }
}
