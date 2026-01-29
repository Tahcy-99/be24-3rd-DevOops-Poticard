package com.poticard.api.chat;

import com.poticard.api.chat.model.ChatDto;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ChatRepositoryImpl implements ChatRepository {

    private final DataSource ds;

    public ChatRepositoryImpl(DataSource dataSource) {
        this.ds = dataSource;
    }

    public ChatDto.ChatRoomListReadResponse read() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://10.10.10.30:3306/test", "root", "qwer1234");
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT usr.user_profile_image AS avatar, cr.room_id AS roomId, usr.user_name AS name, usr.user_affiliation AS company, usr.user_career AS role, cr.unread, cm.content FROM chat_room AS cr\n" +
                        "JOIN user AS usr ON cr.guest_user_id = usr.user_id\n" +
                        "JOIN chat_message AS cm ON cr.room_id = cm.room_id;");

                if (rs.next()) {
                    return new ChatDto.ChatRoomListReadResponse(
                            rs.getString("avatar"),
                            rs.getLong("roomId"),
                            rs.getString("name"),
                            rs.getString("company"),
                            rs.getString("role"),
                            rs.getLong("unread"),
                            rs.getString("content")
                    );
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
