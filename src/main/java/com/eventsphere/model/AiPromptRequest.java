package com.eventsphere.model;

import jakarta.validation.constraints.NotBlank;

public class AiPromptRequest {

    @NotBlank(message = "prompt must not be blank")
    private String prompt;

    public AiPromptRequest() {
    }

    public AiPromptRequest(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
