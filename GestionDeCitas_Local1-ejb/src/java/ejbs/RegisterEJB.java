/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import database.User;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author celia
 */
@Stateless
@LocalBean
public class RegisterEJB {

    @EJB
    Log log;

    public void addUser(String newUser, String newPassword) {
        log.addLog("RegisterEJB::addUser()");

        int id = (int) (Math.random() * 10 + 3);
        User user = new User(newUser, newPassword, id);
        User.users.add(user);

    }

    @PostConstruct
    public void init() {
        System.out.println("RegisterEJB::init() - @PostConstruct del Stateless");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("RegisterEJB::destroy() - @PreDestroy del Stateless");
    }
}
