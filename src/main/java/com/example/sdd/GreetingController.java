package com.example.sdd;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/** Greeting endpoint (CORE 4.2). */
@RestController
public class GreetingController {

    @GetMapping(value = "/api/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> greeting(@RequestParam(name = "name", required = false) String name) {
        String target = (name == null || name.isBlank()) ? "World" : name.strip();
        return Map.of("message", "Hello, " + target + "!");
    }
}
