//package com.devmountain.shelter.animal;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(AnimalRestController.class)
//class AnimalRestControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @Test
//    void addAnimal() {
//
//    }
//
//    @Test
//    void findAnimalById() {
//    }
//
//    @Test
//    void findAllAnimals() throws Exception {
//        RequestBuilder request = MockMvcRequestBuilders.get("/animals");
//        MvcResult result = mvc.perform(request).andReturn();
//        assertEquals(, result.getResponse().getContentAsString());
//
//    }
//}