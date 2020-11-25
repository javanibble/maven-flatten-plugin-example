package com.javanibble.example;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void noParamMessage() throws Exception {

        this.mockMvc.perform(get("/message"))
                .andDo(print()).andExpect(status()
                .isOk())
                .andExpect(jsonPath("$.content")
                .value("Hello, World!"));
    }

    @Test
    public void paramMessage() throws Exception {

        this.mockMvc.perform(get("/message")
                .param("name", "Spring Community"))
                .andDo(print()).andExpect(status()
                .isOk())
                .andExpect(jsonPath("$.content")
                .value("Hello, Spring Community!"));
    }

}

