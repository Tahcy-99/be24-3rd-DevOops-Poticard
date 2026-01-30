package com.poticard.api.chat;

import com.poticard.api.board.model.BoardDto;
import com.poticard.api.chat.model.ChatDto;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatRepositoryImpl implements ChatRepository {

    private final DataSource ds;

    public ChatRepositoryImpl(DataSource dataSource) {
        this.ds = dataSource;
    }

    public List<ChatDto.ChatRoomListReadResponse> read() {
        List<ChatDto.ChatRoomListReadResponse> list = new ArrayList<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            // DB 연결 객체를 다 사용하고 나면 반납할 수 있도록 수정
            try (Connection conn = ds.getConnection()) {
                PreparedStatement pstmt = conn.prepareStatement(
                        "SELECT usr.user_profile_image AS avatar, cr.room_id AS roomId, usr.user_name AS name, usr.user_affiliation AS company, usr.user_career AS role, cr.unread, cm.content FROM chat_room AS cr\n" +
                                "JOIN user AS usr ON cr.guest_user_id = usr.user_id\n" +
                                "JOIN chat_message AS cm ON cr.room_id = cm.room_id;");
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    list.add(new ChatDto.ChatRoomListReadResponse(
                            rs.getString("avatar"),
                            rs.getLong("roomId"),
                            rs.getString("name"),
                            rs.getString("company"),
                            rs.getString("role"),
                            rs.getLong("unread"),
                            rs.getString("content")
                    ));
                }
                return list;

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


