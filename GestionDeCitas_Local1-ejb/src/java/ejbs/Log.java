/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 *
 * @author celia
 */
@Singleton
@LocalBean
public class Log {
    
    @Resource
    TimerService timer;
    long time;

    ArrayList<String> logs = new ArrayList<>();

    //Timer automático
    @Schedule(second = "*/5", minute = "*", hour = "*")
    
    public void scheduleTimer() {
        addLog("Log::scheduleTimer() - @Schedule");
    }
    //Timer programable
    public void setTime(long time) {
        this.time = time;
    }
    
    public void startTimer(){
        timer.createSingleActionTimer(this.time, new TimerConfig());
    }
    
    @Timeout
    public void setTimer(Timer time2){
        addLog("Log::setTimer() - @Timeout");
        timer.createSingleActionTimer(this.time, new TimerConfig());
    }

    public void addLog(String log) {
        logs.add(log);
    }

    public ArrayList<String> getLogArray() {
        return logs;
    }

    @PostConstruct
    public void init() {
        System.out.println("Log::init - @PostConstruct del Singleton Log");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Log::destroy - @PreDestroy del Singleton Log");
    }

}
