package com.learntdd.service;

import com.learntdd.dao.ItemDao;
import com.learntdd.domain.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by z001qgd on 2/27/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

    @Mock
    ItemDao daoMock;

    @InjectMocks
    private ItemService service;

    private Item item;


    @Before
    public void setup(){
       // service= new ItemService();
        item = new Item(1,"TV","SKU1234");
    }

    @After
    public void tearDown(){

    }

    @Test
    public void getItem_Mock_Call(){

       when(daoMock.getItem(anyInt())).thenReturn(new Item());
        //when(daoMock.getItem(anyInt())).thenReturn(new Item());
       Optional<Item> item = service.getItem(0);

        verify(daoMock,times(1)).getItem(anyInt());
        verify(daoMock,atLeastOnce()).getItem(anyInt());
        verify(daoMock,atMost(2)).getItem(anyInt());
        verifyNoMoreInteractions(daoMock);
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
    }

    @Test
    public void verify_NoMoreInteractions(){


        when(daoMock.getItem(anyInt())).thenReturn(new Item());
        //when(daoMock.getItem(anyInt())).thenReturn(new Item());
        Optional<Item> item = service.getItem(0);

        verify(daoMock,times(1)).getItem(anyInt());
        verifyNoMoreInteractions(daoMock);
        assertNotNull(item);


    }

    @Test
    public void verify_InOrder(){

        when(daoMock.insertItem()).thenCallRealMethod();
        when(daoMock.getItem(anyInt())).thenReturn(new Item());
        //when(daoMock.getItem(anyInt())).thenReturn(new Item());
        Optional<Item> item1 = service.getItem(0);
        assertTrue(service.insertItem(item));

        verify(daoMock,times(1)).getItem(anyInt());


        inOrder(daoMock);


        inOrder(daoMock).verify(daoMock).getItem(0);
        inOrder(daoMock).verify(daoMock).insertItem();



    }

    @Test
    public void updateItem(){

        when(daoMock.updateItem(anyObject())).thenReturn(true);
        int itemVal = 1;
        boolean result =  service.updateItem(itemVal);

        assertTrue(result);

        ArgumentCaptor<Item> itemCaptor = ArgumentCaptor.forClass(Item.class);

        verify(daoMock).updateItem(itemCaptor.capture());

        Item item = itemCaptor.getValue();

        assertEquals(itemVal,(int) item.getItemId());

    }




}
