package com.poticard.api.chat;

import com.poticard.api.chat.model.ChatDto;

public interface ChatRepository {
    public ChatDto.ChatRoomListReadResponse read();
}
