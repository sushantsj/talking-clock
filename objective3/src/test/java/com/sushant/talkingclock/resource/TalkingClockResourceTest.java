package com.sushant.talkingclock.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.sushant.talkingclock.dto.ErrorDTO;
import com.sushant.talkingclock.dto.HumanFriendlyTimeResponseDTO;
import com.sushant.talkingclock.service.TalkingClockService;
import com.sushant.talkingclock.validator.TimeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalTime;

/**
 * The type Talking clock resource test.
 */
public class TalkingClockResourceTest {

    private TalkingClockResource talkingClockResource;
    private TalkingClockService talkingClockService;
    private TimeValidator timeValidator;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        talkingClockService = mock(TalkingClockService.class);
        timeValidator = mock(TimeValidator.class);
        talkingClockResource = new TalkingClockResource(talkingClockService, timeValidator);
    }

    /**
     * Test convert to human friendly text with valid time.
     */
    @Test
    public void testConvertToHumanFriendlyTextWithValidTime() {
        // Set up test data and expectations
        String inputTime = "12:00";
        LocalTime localTime = LocalTime.of(12, 0);
        String humanFriendlyTime = "Twelve o'clock";

        when(timeValidator.isValidTime(inputTime)).thenReturn(true);
        when(talkingClockService.convertToHumanFriendlyText(localTime)).thenReturn(humanFriendlyTime);

        // Perform the test
        ResponseEntity<?> responseEntity = talkingClockResource.convertToHumanFriendlyText(inputTime);

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof HumanFriendlyTimeResponseDTO);
        HumanFriendlyTimeResponseDTO responseBody = (HumanFriendlyTimeResponseDTO) responseEntity.getBody();
        assertEquals(humanFriendlyTime, responseBody.getHumanFriendlyText());

        // Verify interactions with mocked objects
        verify(timeValidator, times(1)).isValidTime(inputTime);
        verify(talkingClockService, times(1)).convertToHumanFriendlyText(localTime);
        verifyNoMoreInteractions(timeValidator, talkingClockService);
    }

    /**
     * Test convert to human friendly text with invalid time.
     */
    @Test
    public void testConvertToHumanFriendlyTextWithInvalidTime() {
        // Set up test data and expectations
        String invalidTime = "invalid";

        when(timeValidator.isValidTime(invalidTime)).thenReturn(false);

        // Perform the test
        ResponseEntity<?> responseEntity = talkingClockResource.convertToHumanFriendlyText(invalidTime);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorDTO);
        ErrorDTO responseBody = (ErrorDTO) responseEntity.getBody();
        assertEquals("Invalid time format or value.", responseBody.getErrorMessage());

        // Verify interactions with mocked objects
        verify(timeValidator, times(1)).isValidTime(invalidTime);
        verifyNoMoreInteractions(timeValidator, talkingClockService);
    }
}

