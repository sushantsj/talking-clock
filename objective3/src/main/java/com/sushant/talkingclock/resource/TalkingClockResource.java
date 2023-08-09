package com.sushant.talkingclock.resource;

import com.sushant.talkingclock.dto.ErrorDTO;
import com.sushant.talkingclock.dto.HumanFriendlyTimeResponseDTO;
import com.sushant.talkingclock.service.TalkingClockService;
import com.sushant.talkingclock.validator.TimeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

/**
 * The type Talking clock resource.
 */
@RestController
@RequestMapping("/api")
public class TalkingClockResource {

    private final TalkingClockService talkingClockService;

    private final TimeValidator timeValidator;

    /**
     * Instantiates a new Talking clock resource.
     *
     * @param talkingClockService the talking clock service
     * @param timeValidator       the time validator
     */
    @Autowired
    public TalkingClockResource(TalkingClockService talkingClockService, TimeValidator timeValidator) {
        this.talkingClockService = talkingClockService;
        this.timeValidator = timeValidator;
    }

    /**
     * Convert to human friendly text response entity.
     * @param time the time
     * @return the response entity
     */
    @GetMapping("/convert")
    public ResponseEntity<?> convertToHumanFriendlyText(@RequestParam(required = false) String time) {
        LocalTime inputTime;

        if (time == null || time.isEmpty()) {
            inputTime = LocalTime.now();
        }
        // Check if time parameter is not provided or empty
        else if (timeValidator.isValidTime(time)) {
            inputTime = LocalTime.of(Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
        } else {
            // Validate the input time using the validator
            ErrorDTO errorDTO = new ErrorDTO("Invalid time format or value.");
            return ResponseEntity.badRequest().body(errorDTO);
        }

        // Convert the input time to human-friendly text
        String humanFriendlyTime = talkingClockService.convertToHumanFriendlyText(inputTime);

        // Create and return the DTO with the response data
        HumanFriendlyTimeResponseDTO humanFriendlyTimeResponseDTO = new HumanFriendlyTimeResponseDTO(humanFriendlyTime);
        return ResponseEntity.ok(humanFriendlyTimeResponseDTO);
    }
}
