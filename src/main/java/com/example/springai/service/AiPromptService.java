package com.example.springai.service;

import com.example.springai.model.AiPromptRequest;
import com.example.springai.model.AiPromptResponse;
import org.springframework.stereotype.Service;

@Service
public class AiPromptService {

    // Placeholder for Spring AI integration.
    // Replace with OpenAI client or Spring AI API implementation.
    public AiPromptResponse submitPrompt(AiPromptRequest request) {
        String prompt = request.getPrompt();

        // Example fallback implementation.
        String generatedText = "AI response for prompt: " + prompt + "\n(This is a placeholder. Connect a real AI client in AiPromptService.)";

        return new AiPromptResponse(generatedText);
    }
}
