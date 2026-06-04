package com.eventsphere.model;

public class AiPromptResponse {

    private String result;

    public AiPromptResponse() {
    }

    public AiPromptResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
