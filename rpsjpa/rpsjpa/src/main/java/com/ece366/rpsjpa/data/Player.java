package com.ece366.rpsjpa.data;
import jakarta.persistence.*;

@Entity
@Table(name="PLAYER")
public class Player {
    @Id
    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="TOTAL_WINS")
    private int totalWins;

    @Column(name="TOTAL_LOSSES")
    private int totalLosses;

    @Column(name="TOTAL_GAMES")
    private Integer totalGames;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(int totalLosses) {
        this.totalLosses = totalLosses;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    public String getUserName() {
        return userName;
    }

}
