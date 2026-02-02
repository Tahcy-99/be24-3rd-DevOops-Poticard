package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;
import com.poticard.api.utils.TokenMaker;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

    @Override
    public UserDto.SignupRes signup(UserDto.SignupReq reqDto) {
        try (Connection conn = ds.getConnection()){
            try{
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO users (userEmail, userName, userLoginPw, userPhone) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, reqDto.getEmail());
                pstmt.setString(2, reqDto.getUserName());
                pstmt.setString(3, reqDto.getPassword());
                pstmt.setString(4, reqDto.getUserPhone());

                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()) {
                    UserDto.SignupRes returnDto = new UserDto.SignupRes(
                            reqDto.getUserName()
                    );
                    return returnDto;
                }
            } catch(Exception e){
                throw new RuntimeException(e);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }


        return null;
    }
}
