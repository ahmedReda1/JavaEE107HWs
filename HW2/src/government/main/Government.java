/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package government.main;

import government.presentation.ProviceRegistration;
import government.presentation.CitizenRegistration;
import government.presentation.Report;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author ahmedreda
 */
public class Government
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        Report.reportData();

        Scanner sc = new Scanner(System.in);

        System.out.println("welcome !");
        System.out.println("please select which entity do you want to work with ?");
        System.out.println("1- Citizens \n2- Provinces\n3-exit");
        int entity = sc.nextInt();
        if (entity == 1) {
            System.out.println("Well...which process do you need to preform ?");
            System.out.println("1-register new citizen\n2-update current citizen\n3-delete current citizen");
            int citizenChoice = sc.nextInt();
            switch (citizenChoice) {
                case 1:
                    newCitizen();
                    break;
                case 2:
                    updateCitizen();
                    break;

                case 3:
                    deleteCitizen();
                    break;

                default:
                    System.out.println("please enter valid choice");
                    System.exit(0);

            }

        } else if (entity == 2) {

            System.out.println("Well...which process do you need to preform ?");
            System.out.println("1-register new province\n2-update current province\n3-delete current province");
            int provinceChoice = sc.nextInt();
            switch (provinceChoice) {
                case 1:
                    newProvince();
                    break;
                case 2:
                    updateProvince();
                    break;

                case 3:
                    deleteProvince();
                    break;

                default:
                    System.out.println("please enter a valid choice");
                    System.exit(0);

            }

        } else if (entity == 3) {
            System.exit(0);
        } else {
            System.out.println("please enter a valid number");

        }
        main(args);
    }

    public static void newCitizen() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter citizen's name");
        String name = br.readLine();
        System.out.println("please enter citizen's age");
        String age = sc.next();
        System.out.println("please enter citizen's province name");
        String provineName = sc.next();

        CitizenRegistration.register(name, age, provineName);

    }

    public static void updateCitizen()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter citizen's  id");
        int id = sc.nextInt();
        System.out.println("please enter citizen's name");
        String name = sc.next();
        System.out.println("please enter citizen's age");
        String age = sc.next();
        System.out.println("please enter citizen's province name");
        String provineName = sc.next();

        CitizenRegistration.update(id, name, age, provineName);

    }

    public static void deleteCitizen()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter citizen's id");
        int id = sc.nextInt();

        CitizenRegistration.delete(id);

    }

    private static void newProvince()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter citizen's province name");
        String provineName = sc.next();

        ProviceRegistration.register(provineName);

    }

    private static void updateProvince()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter province's name");
        String provineName = sc.next();
        System.out.println("please enter province's new name");
        String newName = sc.next();

        ProviceRegistration.update(provineName, newName);

    }

    private static void deleteProvince()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("please enter province's name");
        String provineName = sc.next();
        ProviceRegistration.delete(provineName);

    }

}
