package com.domain;

/**
 * Player account class.
 */
public class Account {

    private Integer id;
    private String player_name;
    private String password;
    private Boolean management_status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getManagement_status() {
        return management_status;
    }

    public void setManagement_status(Boolean management_status) {
        this.management_status = management_status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", player_name='" + player_name + '\'' +
                ", management_status=" + management_status +
                '}';
    }
}
