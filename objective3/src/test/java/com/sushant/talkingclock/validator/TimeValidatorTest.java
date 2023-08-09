package com.sushant.talkingclock.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Time validator test.
 */
public class TimeValidatorTest {

    private TimeValidator timeValidator;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        timeValidator = new TimeValidator();
    }

    /**
     * Test valid time format.
     */
    @Test
    public void testValidTimeFormat() {
        assertTrue(timeValidator.isValidTime("12:34"));
        assertTrue(timeValidator.isValidTime("00:00"));
        assertTrue(timeValidator.isValidTime("23:59"));
    }

    /**
     * Test invalid time format.
     */
    @Test
    public void testInvalidTimeFormat() {
        assertFalse(timeValidator.isValidTime("12:60"));
        assertFalse(timeValidator.isValidTime("24:00"));
        assertFalse(timeValidator.isValidTime("12:34:56"));
        assertFalse(timeValidator.isValidTime("12-34"));
        assertFalse(timeValidator.isValidTime("invalid"));
    }

    /**
     * Test valid hour minute values.
     */
    @Test
    public void testValidHourMinuteValues() {
        assertTrue(timeValidator.isValidTime("00:00"));
        assertTrue(timeValidator.isValidTime("01:59"));
        assertTrue(timeValidator.isValidTime("23:00"));
        assertTrue(timeValidator.isValidTime("12:30"));
    }

    /**
     * Test invalid hour minute values.
     */
    @Test
    public void testInvalidHourMinuteValues() {
        assertFalse(timeValidator.isValidTime("-1:00"));
        assertFalse(timeValidator.isValidTime("24:00"));
        assertFalse(timeValidator.isValidTime("12:60"));
        assertFalse(timeValidator.isValidTime("23:61"));
    }
}

