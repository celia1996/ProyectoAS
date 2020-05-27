package ejbs;

import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author celia
 */
@Singleton
@LocalBean
public class Counter {

    @EJB
    Log log;
    HashMap<String, Integer> map = new HashMap<>();
    int loginCount;

    public void newAppointment(String id) {
        log.addLog("Counter::newAppointment() - newAppointment() del Singleton Counter");
        Integer n = map.get(id);
        if (n == null) {
            map.put(id, 1);
        } else {
            map.put(id, n + 1);
        }
    }

    public HashMap<String, Integer> getMap() {
        log.addLog("Counter::getMap()- getMap() del Singleton Counter");
        return map;
    }

    public void newLogin() {
        log.addLog("Counter::newLogin() - newLogin() del Singleton Counter");
        loginCount++;

    }

    public int getLoginCount() {
        log.addLog("Counter::getLoginCount()- getLoginCount() del Singleton Counter");
        return loginCount;
    }

    @PostConstruct
    public void init() {
        System.out.println("Counter::init - @PostConstruct del Singleton Counter");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Counter::destroy - @PreDestroy del Singleton Counter");
    }

}
