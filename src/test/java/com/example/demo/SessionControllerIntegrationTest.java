package com.example.demo;

import com.example.demo.controller.SessionController;
import com.example.demo.repository.SessionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(SessionController.class)
public class SessionControllerIntegrationTest {


    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public SessionRepository sessionRepository;

    @Test
    public void getAllApplications() throws Exception {
        mockMvc.perform(get("/api/v1/session/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                ;

     // verify(sessionRepository, times(1)).findAll();
    }
}
