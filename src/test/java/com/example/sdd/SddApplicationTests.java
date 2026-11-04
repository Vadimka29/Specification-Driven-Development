package com.example.sdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SddApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private Environment env;

    @Test
    @DisplayName("CORE 6.5: application context loads")
    void contextLoads() {
        assertThat(context).isNotNull();
    }

    @Test
    @DisplayName("CORE 5.4: application name is sdd-core")
    void applicationName() {
        assertThat(env.getProperty("spring.application.name")).isEqualTo("sdd-core");
    }
}
