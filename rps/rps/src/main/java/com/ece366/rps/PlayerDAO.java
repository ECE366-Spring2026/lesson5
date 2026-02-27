package com.ece366.rps;

import com.ece366.rps.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO extends DataAccessObject<Player> {

    private static final String GET_ONE = "SELECT user_name, password, total_wins, total_losses " +
            "FROM player WHERE user_name=?";

    private static final String INSERT = "INSERT INTO player (user_name, password) " +
            " VALUES (?, ?)";

    private static final String UPDATE = "UPDATE player SET user_name=?, password=?, total_wins=?, " +
            " total_losses=? WHERE user_name=?";

    private static final String DELETE = "DELETE FROM player WHERE user_name=?";

    public PlayerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Player findById(String id) {
        Player player = new Player();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                player.setUserName(rs.getString("user_name"));
                player.setPassword(rs.getString("password"));
                player.setTotalWins(rs.getInt("total_wins"));
                player.setTotalLosses(rs.getInt("total_losses"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return player;
    }

    @Override
    public Player create(Player dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            // counts from 1!!
            statement.setString(1, dto.getUserName());
            statement.setString(2, dto.getPassword());
            statement.execute();
            return this.findById(dto.getUserName());
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player update(Player dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            // counts from 1!!
            statement.setString(1, dto.getUserName());
            statement.setString(2, dto.getPassword());
            statement.setInt(3, dto.getTotalWins());
            statement.setInt(4, dto.getTotalLosses());
            statement.setString(5, dto.getUserName());
            statement.execute();
            return this.findById(dto.getUserName());
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player delete(Player dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(DELETE);) {
            // counts from 1!!
            statement.setString(1, dto.getUserName());
            statement.execute();
            return this.findById(dto.getUserName());
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}