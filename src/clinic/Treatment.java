package clinic;

import java.time.LocalDateTime;

public class Treatment {
    private String name;
    private String expertise;
    private LocalDateTime dateTime;
    private int duration; // in minutes

    public Treatment(String name, String expertise, LocalDateTime dateTime, int duration) {
        this.name = name;
        this.expertise = expertise;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + " (" + expertise + ") at " + dateTime;
    }
}