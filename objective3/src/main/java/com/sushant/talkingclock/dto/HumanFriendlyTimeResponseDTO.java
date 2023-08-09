package com.sushant.talkingclock.dto;

/**
 * The type Human friendly time response dto.
 */
public class HumanFriendlyTimeResponseDTO {
    private String humanFriendlyText;

    /**
     * Instantiates a new Human friendly time response dto.
     *
     * @param humanFriendlyText the human friendly text
     */
    public HumanFriendlyTimeResponseDTO(String humanFriendlyText) {
        this.humanFriendlyText = humanFriendlyText;
    }

    /**
     * Gets human friendly text.
     *
     * @return the human friendly text
     */
    public String getHumanFriendlyText() {
        return humanFriendlyText;
    }

    /**
     * Sets human friendly text.
     *
     * @param humanFriendlyText the human friendly text
     */
    public void setHumanFriendlyText(String humanFriendlyText) {
        this.humanFriendlyText = humanFriendlyText;
    }
}
