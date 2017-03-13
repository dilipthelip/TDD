package com.learntdd.domain;

/**
 * Created by z001qgd on 2/27/17.
 */
public class Item {

    private Integer itemId;
    private String itemDesc;
    private String sku;

    public Item(int i, String desc, String sku) {
        this.itemId=i;
        this.itemDesc=desc;
        this.sku=sku;
    }

    public Item() {

    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getSku() {
        return sku;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemDesc='" + itemDesc + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
