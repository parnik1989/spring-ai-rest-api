# Spring AI REST API

A Spring Boot REST API starter project with an AI prompt endpoint.

## Features

- Spring Boot 3.2.x REST API
- `/api/ai/prompt` POST endpoint
- Placeholder AI service integration
- GitHub Actions CI for Maven build

## Run locally

1. Navigate to the project:
   ```bash
   cd ~/Projects/spring-ai-rest-api
   ```
2. Build and run with Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Send a request:
   ```bash
   curl -X POST http://localhost:8080/api/ai/prompt \
     -H "Content-Type: application/json" \
     -d '{"prompt":"Write a short AI-powered greeting"}'
   ```

## GitHub setup

1. Initialize Git:
   ```bash
   git init
   git add .
   git commit -m "chore: initial Spring AI REST API project"
   ```
2. Add your GitHub remote and push:
   ```bash
   git remote add origin https://github.com/<your-user>/<your-repo>.git
   git branch -M main
   git push -u origin main
   ```

## Extending AI integration

Replace `AiPromptService` with a real OpenAI or Spring AI client implementation.
Use `OPENAI_API_KEY` or provider-specific environment variables in `application.yml`.
