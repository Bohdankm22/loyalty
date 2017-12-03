package com.projest.loyalty.appinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

public class ManagerInfoBean {

    private String managerToken;
    private String realmId;

    private static ManagerInfoBean instance = new ManagerInfoBean();

    private ManagerInfoBean() {
    }

    public static ManagerInfoBean getInstance() {
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

    public static void setInstance(ManagerInfoBean instance) {
        ManagerInfoBean.instance = instance;
    }
}