package com.gem.nhom1.controller;

import com.gem.nhom1.config.MvcConfig;
import com.gem.nhom1.model.dto.ResponseDTO;
import com.gem.nhom1.model.entities.Dealer;
import com.gem.nhom1.service.DealerService;
import com.gem.nhom1.util.Constant;
import com.gem.nhom1.util.DealerBuilder;
import com.gem.nhom1.util.TestUtil;
import net.arnx.jsonic.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.Set;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Alex on 8/4/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfig.class})
@WebAppConfiguration
public class DealerControllerTest {

    private MockMvc mockMvc;

    private DealerService dealerService;

    @Autowired
    private DealerController dealerController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        dealerService = mock(DealerService.class);
        ReflectionTestUtils.setField(dealerController, "dealerService", dealerService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void findAll() throws Exception {

        Dealer dealer1 = DealerBuilder.createDealer(1, "name1", "address1");
        Dealer dealer2 = DealerBuilder.createDealer(2, "name2", "address2");
        when(dealerService.getList(anyInt(), anyInt())).thenReturn(Arrays.asList(dealer1, dealer2));

        mockMvc.perform(get("/dealer/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data", hasSize(2)))
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_SUSSCESS)))
                .andExpect(jsonPath("$.data[0].dealerId", is(1)))
                .andExpect(jsonPath("$.data[0].name", is("name1")))
                .andExpect(jsonPath("$.data[0].address", is("address1")))
                .andExpect(jsonPath("$.data[1].dealerId", is(2)))
                .andExpect(jsonPath("$.data[1].name", is("name2")))
                .andExpect(jsonPath("$.data[1].address", is("address2")));

        verify(dealerService, times(1)).getList(anyInt(), anyInt());
        verifyNoMoreInteractions(dealerService);
    }

    @Test
    public void findOneIsNotFound() throws Exception {
        when(dealerService.getById(anyInt())).thenReturn(null);
        mockMvc.perform(get("/dealer/{id}", 1))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_ERROR)));

        verify(dealerService, times(1)).getById(anyInt());
        verifyNoMoreInteractions(dealerService);
    }

    @Test
    public void findOneIsFound() throws Exception {

        Dealer dealer = DealerBuilder.createDealer(1, "name1", "address1");
        when(dealerService.getById(1)).thenReturn(dealer);

        mockMvc.perform(get("/dealer/{id}", 1)).andExpect(status().isOk())
                                                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                                                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_SUSSCESS)))
                                                .andExpect(jsonPath("$.data.dealerId", is(1)))
                                                .andExpect(jsonPath("$.data.name", is("name1")))
                                                .andExpect(jsonPath("$.data.address", is("address1")));

        verify(dealerService, times(1)).getById(1);
        verifyNoMoreInteractions(dealerService);
    }

    @Test
    public void insertError() throws Exception {

        Dealer dealer = DealerBuilder.createDealer(1, "truong dai hoc cong nghe dai hoc quoc gia", "");

        mockMvc.perform(post("/dealer/insert").contentType(TestUtil.APPLICATION_JSON_UTF8).content(JSON.encode(dealer)))
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_ERROR)))
                .andExpect(jsonPath("$.message", containsString("độ dài")));

        verifyZeroInteractions(dealerService);
    }

    @Test
    public void insertSuccess() throws Exception {
        Dealer dealer = DealerBuilder.createDealer(1, "Hop Nguyen", "Ha Noi");
        mockMvc.perform(post("/dealer/insert").contentType(TestUtil.APPLICATION_JSON_UTF8).content(JSON.encode(dealer)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_SUSSCESS)))
                .andExpect(jsonPath("$.message", isEmptyString()))
                .andExpect(jsonPath("$.data.name", is("Hop Nguyen")))
                .andExpect(jsonPath("$.data.address", is("Ha Noi")));
        verify(dealerService, times(1)).insert(any(Dealer.class));
        verifyNoMoreInteractions(dealerService);
    }

    @Test
    public void deleteError() throws Exception{

        doThrow(new Exception("Resource not found")).when(dealerService).delete(anyInt());

        mockMvc.perform(delete("/dealer/delete/{id}", 1234))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_ERROR)));

        verify(dealerService, times(1)).delete(1234);
        verifyNoMoreInteractions(dealerService);
    }

    @Test
    public void deleteSuccess() throws Exception{
        doNothing().when(dealerService).delete(35);

        mockMvc.perform(delete("/dealer/delete/{id}", 35))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status", is(Constant.RESPONSE_STATUS_SUSSCESS)));

        verify(dealerService, times(1)).delete(35);
        verifyNoMoreInteractions(dealerService);
    }

}
