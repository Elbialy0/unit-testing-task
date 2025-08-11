package org.example;

public class StopWatch {
    private int minutes;
    private int hours;
    private int days;
    private int dailyWorkingHours;

    public void record(int minutes) {
        if (minutes>0) {
            this.minutes += minutes;
            hours += (int) this.minutes / 60;
            this.minutes %= 60;
            days += (int) (hours / 24);
            hours %= 24;
        }
    }
    public void recordDailyWorkingHours(int dailyWorkingHours){

        this.dailyWorkingHours+=dailyWorkingHours;
        this.days+=(int)(this.dailyWorkingHours/8);
        this.dailyWorkingHours%=8;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getHours(){
        return hours;
    }
    public int getDays(){
        return days;
    }

}

