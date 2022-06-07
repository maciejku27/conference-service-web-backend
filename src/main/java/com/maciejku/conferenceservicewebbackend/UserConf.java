package com.maciejku.conferenceservicewebbackend;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class UserConf {

    private @Id @GeneratedValue Long id;
    private String username;
    private String login;
    private String password;
    private String email;
    private String role;


    UserConf() {}

    UserConf(String username, String login, String password, String email, String role) {

        this.username = username;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserConf))
            return false;
        UserConf userConf = (UserConf) o;
        return Objects.equals(this.id, userConf.id) && Objects.equals(this.username, userConf.username) && Objects.equals(this.login, userConf.login) && Objects.equals(this.password, userConf.password) && Objects.equals(this.email, userConf.email) && Objects.equals(this.role, userConf.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username, this.login, this.password, this.email, this.role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", username='" + this.username + '\'' +
                ", login='" + this.login + '\'' +
                ", password='" + this.password + '\'' +
                ", email='" + this.email + '\'' +
                ", role='" + this.role + '\'' +
                '}';
    }

}