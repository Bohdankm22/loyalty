package com.projest.loyalty.entity;

public class LoyaltyProgram {

    private long id;
    private String name;
    private Company company;

    public LoyaltyProgram(long id, String name, Company company) {
        this.id = id;
        this.name = name;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
