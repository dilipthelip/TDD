package com.learntdd.dao;

import com.learntdd.domain.Item;
import org.springframework.stereotype.Repository;

/**
 * Created by z001qgd on 2/27/17.
 */
@Repository
public class ItemDao {


    public Item getItem(int itemId) {

        Item item =new Item();
        item.setItemDesc("Samsung TV");
        item.setItemId(123);
        item.setSku("SKKKHU");
        return item;
    }
}
