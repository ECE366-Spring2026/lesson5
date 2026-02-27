package com.ece366.rps;

import com.ece366.rps.util.DataTransferObject;

public class Player implements DataTransferObject {
    private String userName;
    private String password;
    private Integer totalWins;
    private Integer totalLosses;

    public String getId() {
        return userName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(Integer totalWins) {
        this.totalWins = totalWins;
    }

    public Integer getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(Integer totalLosses) {
        this.totalLosses = totalLosses;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", totalWins='" + totalWins + '\'' +
                ", totalLosses='" + totalLosses + '\'' +
                '}';
    }
}