package org.mustangproject.server.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@WebMvcTest(VersionController.class)
public class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    @Test
    @DisplayName("Test /notice endpoint")
    public void testNotice() throws Exception {
        String expectedResponse = "REST-Converter https://github.com/ZUGFeRD/REST-Converter is licensed under the EUPL by \"usegroup\" and uses Spring boot under Apache License and https://github.com/AgID/EeISI-mapper/ under the EUPL";

        mockMvc.perform(MockMvcRequestBuilders.get("/mustang/notice")
                        .header("USERNAME", "testuser"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}