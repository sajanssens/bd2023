package com.example;

import com.example.domain.Contact;
import com.example.domain.ContactDaoDetach;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class AppDetachment {

    // App creates EntityManager
    private static final EntityManager em = Persistence.createEntityManagerFactory("ContactServiceMySQL").createEntityManager();

    private static void test() {
        ContactDaoDetach dao = new ContactDaoDetach(em);

        Contact bram = new Contact("Bram", new Date());
        dao.save(bram); // bram is detached

        System.out.println("updating 1...");
        System.out.println(bram);
        Contact arie = dao.updateFirstname(1, "arie"); // works because we do a find first
        System.out.println(arie); // arie is detached

        System.out.println("updating 2...");
        System.out.println(arie);
        arie.setFirstname("harry");

        // save won't work now anymore, because entity is detached
        dao.save(arie);
        Contact harryOrArie = dao.find(1); // harryOrArie is managed
        System.out.println(harryOrArie); // will stay arie

        // merge will update arie to harry
        Contact harry = dao.update(arie);
        System.out.println(harry);
    }

    public static void main(String[] args) {test();}
}
