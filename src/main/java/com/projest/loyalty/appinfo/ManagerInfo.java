package com.projest.loyalty.appinfo;

public class ManagerInfo {

    private String managerToken;
    private String realmId;

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
}