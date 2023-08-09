package com.sushant.talkingclock.validator;

import org.springframework.stereotype.Component;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The type Time validator.
 */
@Component
public class TimeValidator {

    // Regular expression pattern for matching hh:mm format
    private static final Pattern TIME_PATTERN = Pattern.compile("^([01]?[0-9]|2[0-3]):([0-5][0-9])$");

    /**
     * Is valid time boolean.
     *
     * @param time the time
     * @return the boolean
     */
    public boolean isValidTime(String time) {

        Matcher matcher = TIME_PATTERN.matcher(time);
        if (!matcher.matches()) {
            return false; // Invalid time format
        }

        int hour = Integer.parseInt(matcher.group(1));
        int minute = Integer.parseInt(matcher.group(2));

        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59; // Validate hour and minute values
    }
}
