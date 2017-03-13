package com.learntdd.service;

import com.learntdd.dao.ItemDao;
import com.learntdd.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by z001qgd on 2/27/17.
 */
@Service
@Slf4j
public class ItemService {

    @Autowired
    ItemDao itemDao;


    public Optional<Item> getItem(int itemId) {

       Optional<Item> item = Optional.empty();

        try{

            item = item.ofNullable(itemDao.getItem(itemId));

        }catch (Exception e){
            log.error("Exception in service : getItem : "+ e.getMessage() );
            throw  e;
        }
        return  item;
    }

    public boolean insertItem(Item item) {
        return itemDao.insertItem();
    }

    public boolean updateItem(int itemId) {

        Item item = new Item();
        item.setItemId(itemId);
        return itemDao.updateItem(item);
    }
}
