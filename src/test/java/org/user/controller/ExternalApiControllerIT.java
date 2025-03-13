package org.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ExternalApiControllerIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void getExternalData_ShouldReturnValidResponse() throws Exception {
        // Act & Assert: Call the real external API through our service
        mockMvc.perform(get("/external")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.externalUserId").isNumber())
                .andExpect(jsonPath("$.taskId").isNumber())
                .andExpect(jsonPath("$.taskTitle").isString())
                .andExpect(jsonPath("$.completed").isBoolean());
    }
}
