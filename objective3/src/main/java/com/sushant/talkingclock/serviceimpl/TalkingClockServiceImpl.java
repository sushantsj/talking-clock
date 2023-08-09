package com.sushant.talkingclock.serviceimpl;

import com.sushant.talkingclock.service.TalkingClockService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

/**
 * The type Talking clock service.
 */
@Service
public class TalkingClockServiceImpl implements TalkingClockService {

    @Override
    public String convertToHumanFriendlyText(LocalTime time) {
        return covertTime(time);
    }

    private String covertTime(LocalTime time) {
        int hour = time.getHour() % 12;
        int minute = time.getMinute();

        String[] numbers = {
                "Twelve", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven"
        };

        String[] minutes = {
                "o'clock", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen", "Twenty", "Twenty one", "Twenty two", "Twenty three",
                "Twenty four", "Twenty five", "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine"
        };

        String timeText = "";

        if (minute == 0) {
            timeText = numbers[hour] + " " + minutes[minute];
        } else if (minute <= 30) {
            if (minute == 15) {
                timeText = "Quarter past " + numbers[hour];
            } else if (minute == 30) {
                timeText = "Half past " + numbers[hour];
            } else {
                timeText = minutes[minute] + " past " + numbers[hour];
            }
        } else {
            if (minute == 45) {
                timeText = "Quarter to " + numbers[(hour + 1) % 12];
            } else {
                timeText = minutes[60 - minute] + " to " + numbers[(hour + 1) % 12];
            }
        }

        return timeText;
    }
}