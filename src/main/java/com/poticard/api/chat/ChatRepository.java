package com.poticard.api.chat;

import com.poticard.api.chat.model.ChatDto;

import java.util.List;

public interface ChatRepository {
    public List<ChatDto.ChatRoomListReadResponse> read();
}
