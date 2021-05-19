package arnaud.boige.mareu.model;


import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Reunion {

    @PrimaryKey
    private long id;
    private String mDay;
    private String mMonth;
    private String mYear;
    private String mHour;
    private String mMinute;
    private String mLocation;
    private String mSubject;
    private ArrayList<String> mParticipants;

    public Reunion(long id, String day, String month, String year, String hour, String minute, String location, String subject, ArrayList<String> participants) {
        this.id = id;
        mDay = day;
        mMonth = month;
        mYear = year;
        mHour = hour;
        mMinute = minute;
        mLocation = location;
        mSubject = subject;
        mParticipants = participants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return mDay;
    }

    public void setDay(String day) {
        mDay = day;
    }

    public String getMonth() {
        return mMonth;
    }

    public void setMonth(String month) {
        mMonth = month;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String hour) {
        mHour = hour;
    }

    public String getMinute() {
        return mMinute;
    }

    public void setMinute(String minute) {
        mMinute = minute;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public ArrayList<String> getParticipants() {
        return mParticipants;
    }

    public void setParticipants(ArrayList<String> participants) {
        mParticipants = participants;
    }
}
