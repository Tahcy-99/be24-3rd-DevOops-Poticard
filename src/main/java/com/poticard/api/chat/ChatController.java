package com.poticard.api.chat;

import com.poticard.api.chat.model.ChatDto;
import com.poticard.api.common.BaseResponse;
import com.poticard.api.common.Controller;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChatController implements Controller {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @Override
    public BaseResponse process(HttpServletRequest req, HttpServletResponse resp) {
        ChatDto.ChatRoomListReadResponse returnDto = null;

        if(req.getRequestURI().contains("chat") && req.getMethod().equals("GET")) {
            returnDto = chatService.readChatRoomList();
        }

        return BaseResponse.success(returnDto);
    }
}
