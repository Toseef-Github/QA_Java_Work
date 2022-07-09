package com.qa.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Car;


@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = {"classpath:car-schema.sql",
		"classpath:car-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CarControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    private int add(int a, int b) {
        return a + b;
    }

    @Test
    void testDemo() {
        assertEquals(2, add(1, 1));
    }

    @Test
    void testCreate() throws Exception {
        Car testCar = new Car("Audi", "A5", 2019);
        String testCarAsJSON = this.mapper.writeValueAsString(testCar);
        RequestBuilder req = post("/createCar").content(testCarAsJSON).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
        Car createdCar = new Car(1, "Audi", "A5", 2019);
        String createdCarAsJSON = this.mapper.writeValueAsString(createdCar);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdCarAsJSON);

        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }
}


