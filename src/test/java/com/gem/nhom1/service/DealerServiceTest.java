package com.gem.nhom1.service;

import com.gem.nhom1.dao.DealerDao;
import com.gem.nhom1.model.entities.Dealer;
import com.gem.nhom1.service.impl.DealerServiceImpl;
import com.gem.nhom1.util.DealerBuilder;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
/**
 * Created by Alex on 8/5/2016.
 */
public class DealerServiceTest {

    private DealerDao dealerDao;

    private DealerService dealerService;

    @Before
    public void setUp(){
        dealerDao = mock(DealerDao.class);
        dealerService = new DealerServiceImpl(dealerDao);
    }

    @Test
    public void findAll(){

        Dealer dealer1 = DealerBuilder.createDealer(1, "name1", "address1");
        Dealer dealer2 = DealerBuilder.createDealer(2, "name2", "address2");
        List<Dealer> dealers = Arrays.asList(dealer1, dealer2);

        when(dealerDao.getList(0,15)).thenReturn(dealers);
        List<Dealer> dealerList = dealerService.getList(0, 15);

        verify(dealerDao, times(1)).getList(0,15);
        verifyNoMoreInteractions(dealerDao);

        assertThat(dealerList, is(dealers));

    }

    @Test
    public void findOne(){

        Dealer dealer = DealerBuilder.createDealer(1, "name1", "address1");

        when(dealerDao.getById(1)).thenReturn(dealer);

        Dealer dealer1 = dealerService.getById(2);
        Dealer dealer2 = dealerService.getById(1010);

        assertThat(dealer, is(dealer1));
        assertNull(dealer2);

    }
}
