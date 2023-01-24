package com.test3.restTest3;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class HomeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    HomeRepository homeRepository;
    @MockBean
    HomeService homeService;
    @Test
    public void testShouldAddHome() throws Exception {
        Home home = new Home("addr1");
        home.setNumber(1);
        when(homeService.addHome(any(Home.class))).thenAnswer((invocationOnMock -> invocationOnMock.getArgument(0)));
        ResultActions response = mockMvc.perform(post("/homes").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(home)));

        response.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.address",
                        is(home.getAddress())));
        verify(homeService).addHome(any(Home.class));

        ArgumentCaptor<Home> homeArgumentCaptor =ArgumentCaptor.forClass(Home.class);
        verify(homeService).addHome(homeArgumentCaptor.capture());
        Home home1 = homeArgumentCaptor.getValue();
        System.out.println(home1.toString());

    }

    @Test
    public void testShouldReturnAllHomes() throws Exception {
        List<Home> homesList = new ArrayList<>();
        homesList.add(new Home("addr1"));
        homesList.add(new Home("addr2"));
        homesList.add(new Home("addr3"));

        given(homeService.findAllHomes()).willReturn(homesList);

        ResultActions response = mockMvc.perform(get("/homes"));
        response.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(homesList.size())));
    }

    @Test
    public void testShouldReturnHomeById() throws Exception {
        Home home = new Home("addr1");
        home.setNumber(1);
        System.out.println(home.getNumber());
        given(homeService.getHomeById(home.getNumber())).willReturn(Optional.of(home));
        ResultActions response = mockMvc.perform(get("/homes/{id}", home.getNumber()));

        response.andExpect(status().isOk()).andDo(print())
                .andExpect(jsonPath("$.number", is(home.getNumber())))
                .andExpect(jsonPath("$.address", is(home.getAddress())));
    }
}
