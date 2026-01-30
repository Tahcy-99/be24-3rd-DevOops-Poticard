package com.poticard.api.namecard;

import com.poticard.api.namecard.model.NamecardDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NamecardRepositoryImpl implements NamecardRepository {
    // DB 연결 객체를 의존성 주입으로 전달 받음
    private final DataSource ds;

    public NamecardRepositoryImpl(DataSource dataSource) {
        this.ds = dataSource;
    }

    @Override
    public NamecardDto.NamecardRes search(String userId) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // DB 연결 객체를 다 사용하고 나면 반납할 수 있도록 수정
            try (Connection conn = ds.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT users.userId, userName, userEmail, userUrl, userAffiliation, namecardTitle, userPhone, userAddress, userGender, color, typoFont, cardTexture, logo, qrcode, avatar, keywords FROM users LEFT JOIN namecard ON users.userId=namecard.userId WHERE users.userId = ?");
                pstmt.setInt(1, Integer.parseInt(userId));
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return new NamecardDto.NamecardRes(
                            rs.getString("userId"),
                            rs.getString("userName"),
                            rs.getString("userEmail"),
                            rs.getString("userUrl"),
                            rs.getString("userAffiliation"),
                            rs.getString("namecardTitle"),
                            rs.getString("userPhone"),
                            rs.getString("userAddress"),
                            rs.getString("userGender"),
                            rs.getString("color"),
                            rs.getString("typoFont"),
                            rs.getString("cardTexture"),
                            rs.getBoolean("logo"),
                            rs.getBoolean("qrcode"),
                            rs.getString("avatar"),
                            rs.getString("keywords")
                            );
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
