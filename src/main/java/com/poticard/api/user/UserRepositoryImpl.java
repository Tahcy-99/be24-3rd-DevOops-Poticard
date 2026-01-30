package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;
import com.poticard.api.utils.TokenMaker;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepositoryImpl implements UserRepository {
    // DB 연결 객체를 의존성 주입으로 전달 받음
    private final DataSource ds;

    public UserRepositoryImpl(DataSource dataSource) {
        this.ds = dataSource;
    }


    @Override
    public UserDto.LoginRes login(UserDto.LoginReq reqDto) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // DB 연결 객체를 다 사용하고 나면 반납할 수 있도록 수정
            try (Connection conn = ds.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT userId, userName FROM users WHERE userEmail=? AND userLoginPw=?");
                pstmt.setString(1, reqDto.getLoginEmail());
                pstmt.setString(2, reqDto.getLoginPw());
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    Integer userId = rs.getInt("userId");
                    String userName = rs.getString("userName");
                    UserDto.LoginRes jwt = new UserDto.LoginRes();
                    jwt.setJwt(TokenMaker.getUserToken(userId, userName));
                    return jwt;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("login failed");
        return null;
    }
}
