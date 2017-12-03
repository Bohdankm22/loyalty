package com.projest.loyalty.appinfo;

import com.intuit.ipp.data.Item;

import java.util.List;

public class ManagerInfo {

    private String managerToken;
    private String realmId;
    private List<Item> goods;

    private static ManagerInfo instance = new ManagerInfo();

    private ManagerInfo() {
    }

    public static ManagerInfo getInstance() {
        return instance;
    }

    public String getManagerToken() {
        return managerToken;
    }

    public void setManagerToken(String managerToken) {
        this.managerToken = managerToken;
    }

    public String getRealmId() {
        return realmId;
    }

    public void setRealmId(String realmId) {
        this.realmId = realmId;
    }

    public static void setInstance(ManagerInfo instance) {
        ManagerInfo.instance = instance;
    }

    public List<Item> getGoods() {
        return goods;
    }

    public void setGoods(List<Item> goods) {
        this.goods = goods;
    }

    public Item getGoodById(String itemId) {
        for (Item item: getGoods()) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}