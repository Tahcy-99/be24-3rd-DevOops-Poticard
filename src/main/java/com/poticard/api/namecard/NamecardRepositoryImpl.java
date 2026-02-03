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

    // DB에서 유저 명함을 불러오는 메소드
    @Override
    public NamecardDto.SearchRes search(String userId) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            // DB 연결 객체를 다 사용하고 나면 반납할 수 있도록 수정
            try (Connection conn = ds.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT users.userId, userName, userEmail, userUrl, userAffiliation, namecardTitle, userPhone, userAddress, userGender, color, typoFont, cardTexture, logo, qrcode, avatar, keywords FROM users LEFT JOIN namecard ON users.userId=namecard.userId WHERE users.userId = ?");
                pstmt.setInt(1, Integer.parseInt(userId));
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return new NamecardDto.SearchRes(
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

    // 명함 생성하는 메소드 (유저 입력값을 INSERT)
    @Override
    public NamecardDto.CreateRes create(NamecardDto.CreateReq dto) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            String sql = "INSERT INTO namecard (userId, namecardTitle, layoutType, color, typoFont, cardTexture, logo, qrcode, avatar, keywords)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ? ,? ,?, ?)";

            // DB 연결 객체를 다 사용하고 나면 반납할 수 있도록 수정
            try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, Integer.parseInt(dto.getUserId()));
                pstmt.setString(2, dto.getNamecardTitle());
                pstmt.setString(3, dto.getLayoutType());
                pstmt.setString(4, dto.getColor());
                pstmt.setString(5, dto.getTypoFont());
                pstmt.setString(6, dto.getCardTexture());
                pstmt.setBoolean(7, dto.getLogo());
                pstmt.setBoolean(8, dto.getQrcode());
                pstmt.setString(9, dto.getAvatar());
                pstmt.setString(10, dto.getKeywords());

                int affectedRows = pstmt.executeUpdate();
                NamecardDto.CreateRes responseDto = new NamecardDto.CreateRes(null);

                if (affectedRows > 0) {
                    responseDto.setSuccess(true);
                    return responseDto;
                }
                responseDto.setSuccess(false);
                return responseDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
