package com.learntdd.service;

import com.learntdd.dao.ItemDao;
import com.learntdd.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z001qgd on 2/27/17.
 */
@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;


    public Item getItem(int itemId) {

        return itemDao.getItem(itemId);
    }
}
