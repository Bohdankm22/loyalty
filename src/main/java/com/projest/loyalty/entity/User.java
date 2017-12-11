package com.projest.loyalty.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;

    @Column(unique = true)
    private String login;
    private String password;
    private UserRole userRole;
    private long annualSalary;

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.surname = userBuilder.surname;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.userRole = userBuilder.userRole;
        this.annualSalary = userBuilder.annualSalary;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public long getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(long annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", annualSalary=" + annualSalary +
                '}';
    }

    //Builder Class
    public static class UserBuilder {

        private String name;
        private String surname;
        private String login;
        private String password;
        private UserRole userRole;
        private long annualSalary;

        public UserBuilder(String login, String password, UserRole userRole) {
            this.login = login;
            this.password = password;
            this.userRole = userRole;
        }

        // Optional parameters
        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder setAnnualSalary(long annualSalary) {
            this.annualSalary = annualSalary;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
