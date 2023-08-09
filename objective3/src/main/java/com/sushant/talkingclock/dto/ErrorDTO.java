package com.sushant.talkingclock.dto;

/**
 * The type Error dto.
 */
public class ErrorDTO {

    private String errorMessage;

    /**
     * Instantiates a new Error dto.
     *
     * @param errorMessage the error message
     */
    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets error message.
     *
     * @param errorMessage the error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
