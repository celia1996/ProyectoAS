package ejbs;

import database.User;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;

/**
 *
 * @author celia
 */
@Stateful
@LocalBean
public class UserEJB {
@EJB
Log log;
    private String userName;
    private String password;
    
    public void setUser(User user){
        log.addLog("UserEJB::setUser()");
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    public String getUserName() {
        log.addLog("UserEJB::getUserName()");
        return userName;
    }

    public String getPassword() {
        log.addLog("UserEJB::getPassword()");
        return password;
    }
    
        @Remove
    public void remove() {
        System.out.println("UserEJB::remove - @Remove del Stateful");
    }

    @PostConstruct
    public void init() {
        System.out.println("UserEJB::init - @PostConstruct del Stateful");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserEJB::destroy - @PreDestroy del Stateful");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("UserEJB::postActivate - @PostActivate del Stateful");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("UserEJB::prePassivate - @PrePassivate del Stateful");
    }
    
}
