package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PrimaryKeyGenerator {

    private int counter = 1;

    @Scheduled(cron = "0 0 6 * * *")
    public void resetDailyCounter(){
        this.counter = 1;
    }

    public void increase(){
        this.counter +=1;
    }

    public String getCounterString() {
        int lengthOfZero = 5 - String.valueOf(this.counter).length();

        String counterString = "";

        for (int i = 0; i < lengthOfZero; i++) {
            counterString = counterString.concat("0");
        }

        counterString = counterString.concat(String.valueOf(this.counter));

        return counterString;
    }

    public String getPrimaryKey(){
        String primaryKey = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(this.getCounterString());
        this.increase();
        return primaryKey;
    }

}
