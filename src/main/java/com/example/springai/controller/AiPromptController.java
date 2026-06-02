package com.example.springai.controller;

import com.example.springai.model.AiPromptRequest;
import com.example.springai.model.AiPromptResponse;
import com.example.springai.service.AiPromptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiPromptController {

    private final AiPromptService aiPromptService;

    public AiPromptController(AiPromptService aiPromptService) {
        this.aiPromptService = aiPromptService;
    }

    @PostMapping("/prompt")
    public ResponseEntity<AiPromptResponse> createPrompt(@Valid @RequestBody AiPromptRequest request) {
        AiPromptResponse response = aiPromptService.submitPrompt(request);
        return ResponseEntity.ok(response);
    }
}
