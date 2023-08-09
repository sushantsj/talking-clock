package com.sushant.talkingclock.serviceimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Talking class service impl test.
 */
public class TalkingClassServiceImplTest {

    private TalkingClockServiceImpl talkingClockService;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        talkingClockService = new TalkingClockServiceImpl();
    }

    /**
     * Test convert to human friendly text hour only.
     */
    @Test
    public void testConvertToHumanFriendlyText_HourOnly() {
        LocalTime time = LocalTime.of(10, 0);
        String expected = "Ten o'clock";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }

    /**
     * Test convert to human friendly text quarter past.
     */
    @Test
    public void testConvertToHumanFriendlyText_QuarterPast() {
        LocalTime time = LocalTime.of(3, 15);
        String expected = "Quarter past Three";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }

    /**
     * Test convert to human friendly text half past.
     */
    @Test
    public void testConvertToHumanFriendlyText_HalfPast() {
        LocalTime time = LocalTime.of(7, 30);
        String expected = "Half past Seven";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }

    /**
     * Test convert to human friendly text quarter to.
     */
    @Test
    public void testConvertToHumanFriendlyText_QuarterTo() {
        LocalTime time = LocalTime.of(9, 45);
        String expected = "Quarter to Ten";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }

    /**
     * Test convert to human friendly text past minutes.
     */
    @Test
    public void testConvertToHumanFriendlyText_PastMinutes() {
        LocalTime time = LocalTime.of(6, 21);
        String expected = "Twenty one past Six";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }

    /**
     * Test convert to human friendly text to minutes.
     */
    @Test
    public void testConvertToHumanFriendlyText_ToMinutes() {
        LocalTime time = LocalTime.of(2, 44);
        String expected = "Sixteen to Three";
        String result = talkingClockService.convertToHumanFriendlyText(time);
        assertEquals(expected, result);
    }
}
