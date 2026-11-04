package com.example.sdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebEndpointsTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("CORE 4.1.1, 4.1.2: GET / returns 200 text/plain with the project name")
    void home() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Specification-Driven Development"));
    }

    @Test
    @DisplayName("CORE 4.2.1, 4.2.2: greeting without name returns Hello, World!")
    void greetingDefault() throws Exception {
        mvc.perform(get("/api/greeting"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Hello, World!\"}", true));
    }

    @Test
    @DisplayName("CORE 4.2.3: greeting with name trims whitespace")
    void greetingWithName() throws Exception {
        mvc.perform(get("/api/greeting").param("name", "  Ada "))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Hello, Ada!\"}", true));
    }

    @Test
    @DisplayName("CORE 4.2.4: greeting with blank name behaves as absent")
    void greetingBlankName() throws Exception {
        mvc.perform(get("/api/greeting").param("name", "   "))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Hello, World!\"}", true));
    }

    @Test
    @DisplayName("CORE 4.3.1: health endpoint reports UP")
    void health() throws Exception {
        mvc.perform(get("/actuator/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    @DisplayName("CORE 4.3.2: other actuator endpoints are not exposed")
    void otherActuatorEndpointsHidden() throws Exception {
        mvc.perform(get("/actuator/env")).andExpect(status().isNotFound());
        mvc.perform(get("/actuator/beans")).andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("CORE 4.4.1: unknown path returns 404")
    void unknownPath() throws Exception {
        mvc.perform(get("/does-not-exist")).andExpect(status().isNotFound());
    }
}
