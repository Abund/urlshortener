package com.and.urlshorterner1.controller;

import com.and.urlshorterner1.service.manager.impl.UrlManagerImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlController.class)
class UrlControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UrlController urlController;

    @MockBean
    UrlManagerImpl urlManager;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shortenUrl() {
    }

    @Test
    void getUrl() {
    }

    @Test
    void getUrlRedirect() {
    }
}