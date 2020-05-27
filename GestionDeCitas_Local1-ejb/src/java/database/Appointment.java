package database;

import java.util.ArrayList;

public class Appointment {

    private String date;
    private String time;
    private int id;
    private int available;

    public Appointment(String date, String time, int id, int available) {
        this.date = date;
        this.time = time;
        this.id = id;
        this.available = available;

    }

    public static ArrayList<Appointment> appointments = new ArrayList<Appointment>() {
        {
            add(new Appointment("16/03/20", "10:30", 1, 0));
            add(new Appointment("16/03/20", "10:00", 2, 0));
            add(new Appointment("18/03/20", "10:30", 3, 0));
            add(new Appointment("19/03/20", "10:30", 4, 0));
            add(new Appointment("20/03/20", "10:30", 5, 0));
        }
    };

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public static Appointment getAppointmentById(int id) {
        for (Appointment appointment : appointments) {
            if (id == appointment.getId()) {
                return appointment;
            }
        }
        return null;
    }

}
