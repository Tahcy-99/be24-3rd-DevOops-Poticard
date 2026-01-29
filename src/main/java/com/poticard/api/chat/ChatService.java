package com.poticard.api.chat;

import com.poticard.api.board.BoardRepository;
import com.poticard.api.board.model.BoardDto;
import com.poticard.api.chat.model.ChatDto;

import java.util.List;

public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatDto.ChatRoomListReadResponse> readChatRoomList() {
        List<ChatDto.ChatRoomListReadResponse> returnDto = chatRepository.read();

        return returnDto;
    }
}
