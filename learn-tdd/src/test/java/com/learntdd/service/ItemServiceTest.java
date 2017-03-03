package com.learntdd.service;

import com.learntdd.dao.ItemDao;
import com.learntdd.domain.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by z001qgd on 2/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemDao daoMock;

    @InjectMocks
    private ItemService service;


    @Before
    public void setup(){
       // service= new ItemService();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void getItem_Mock_Call(){

       when(daoMock.getItem(anyInt())).thenReturn(new Item());
       Optional<Item> item = service.getItem(0);

        assertNotNull(item);

    }

    @Test
    public void getItem_Real_Call(){

        when(daoMock.getItem(anyInt())).thenCallRealMethod();
        Optional<Item> item = service.getItem(0);

        assertNotNull(item);
        assertEquals(123,item.get().getItemId().intValue());

    }

    @Test(expected = RuntimeException.class)
    public void getItem_Exception(){

        when(daoMock.getItem(anyInt())).thenThrow(new RuntimeException());
        Optional<Item> item = service.getItem(0);

        assertNotNull(item);
        assertEquals(123,item.get().getItemId().intValue());

    }


}
