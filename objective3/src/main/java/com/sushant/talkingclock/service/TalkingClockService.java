package com.sushant.talkingclock.service;

import java.time.LocalTime;

/**
 * The interface Talking clock service.
 */
public interface TalkingClockService {
    /**
     * Convert to human friendly text string.
     *
     * @param time the time
     * @return the string
     */
    String convertToHumanFriendlyText(LocalTime time);
}