package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private final HikariDataSource ds;

    public UserRepositoryImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public UserDto create(UserDto dto) {
        String sql = "INSERT INTO users (user_email, user_name, user_login_pw) VALUES (?, ?, ?)";

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dto.getEmail());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getPassword());

            ps.executeUpdate();
            return dto;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDto findByEmail(String email) {
        String sql = "SELECT user_email, user_name, user_login_pw FROM users WHERE user_email = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                return new UserDto(
                        rs.getString("user_email"),
                        rs.getString("user_name"),
                        rs.getString("user_login_pw")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        String sql = "SELECT user_email, user_name, user_login_pw " +
                "FROM users WHERE user_email = ? AND user_login_pw = ?";

        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                return new UserDto(
                        rs.getString("user_email"),
                        rs.getString("user_name"),
                        rs.getString("user_login_pw")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
