package com.eventsphere.controller;
import com.eventsphere.model.AiPromptRequest;
import com.eventsphere.model.AiPromptResponse;
import com.eventsphere.service.AiPromptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/health")
    public String getApplicationHealth(@RequestParam String health) {
        return health+" is great!";
    }
    
}
