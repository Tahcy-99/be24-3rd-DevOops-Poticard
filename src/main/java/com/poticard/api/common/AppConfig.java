package com.poticard.api.common;

import com.poticard.api.board.*;
import com.poticard.api.chat.ChatController;
import com.poticard.api.chat.ChatRepository;
import com.poticard.api.chat.ChatRepositoryImpl;
import com.poticard.api.chat.ChatService;
import com.poticard.api.image.*;
import com.poticard.api.user.UserController;
import com.zaxxer.hikari.HikariDataSource;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    private final HikariDataSource ds = new HikariDataSource();

    private final BoardRepository boardRepository = new BoardCpRepositoryImpl(ds);
    private final BoardService boardService = new BoardService(boardRepository);
    private final BoardController boardController = new BoardController(boardService);

    private final UserController userController = new UserController();

    private final ChatRepository chatRepository = new ChatRepositoryImpl(ds);
    private final ChatService chatService = new ChatService(chatRepository);
    private final ChatController chatController = new ChatController(chatService);

    // 이미지 처리 기능
    private final ImageRepository imageRepository = new ImageRepository();
    private final ImageService imageService = new ImageServiceImpl(imageRepository);
    private final ImageController imageController = new ImageController(imageService);


    public AppConfig() {
        ds.setJdbcUrl("jdbc:mariadb://10.10.10.30:3306/test");
        ds.setUsername("root");
        ds.setPassword("qwer1234");

        controllerMap.put("/board/register", boardController);
        controllerMap.put("/board/read", boardController);
        controllerMap.put("/user/signup", userController);
        controllerMap.put("/user/login", userController);
        controllerMap.put("/chat", chatController);

        // URI 맵핑
        controllerMap.put("/image/upload", imageController);
    }

    // 특정 uri를 이용해서 특정 컨트롤러 객체를 반환하는 메소드
    public Controller getController(String uri) {
        return controllerMap.get(uri);
    }
}
