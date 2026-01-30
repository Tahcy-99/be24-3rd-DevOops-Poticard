package com.poticard.api.common;

import com.poticard.api.board.*;
import com.poticard.api.chat.ChatController;
import com.poticard.api.chat.ChatRepository;
import com.poticard.api.chat.ChatRepositoryImpl;
import com.poticard.api.chat.ChatService;
import com.poticard.api.image.*;
import com.poticard.api.namecard.controller.NamecardCreateController;
import com.poticard.api.namecard.controller.NamecardSearchController;
import com.poticard.api.namecard.NamecardRepositoryImpl;
import com.poticard.api.namecard.NamecardRepository;
import com.poticard.api.namecard.NamecardService;
import com.poticard.api.user.UserController;
import com.poticard.api.user.*;
import com.zaxxer.hikari.HikariDataSource;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    private final Map<String, Controller> controllerMap = new HashMap<>();

    private final HikariDataSource ds = new HikariDataSource();

    // ===== Board DI =====
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

    // 명함 처리 기능
    private final NamecardRepository namecardRepository = new NamecardRepositoryImpl(ds);
    private final NamecardService namecardService = new NamecardService(namecardRepository);
    private final NamecardSearchController namecardSearchController = new NamecardSearchController(namecardService);
    private final NamecardCreateController namecardCreateController = new NamecardCreateController(namecardService);


    public AppConfig() {
        ds.setJdbcUrl("jdbc:mariadb://10.10.10.30:3306/test");
    // ===== User DI (Board 흐름이랑 동일하게) =====
    private final UserRepository userRepository = new UserRepositoryImpl(ds);
    private final UserService userService = new UserService(userRepository);
    private final UserController userController = new UserController(userService);

    public AppConfig() {
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mariadb://192.168.230.113:3306/web");
        ds.setUsername("root");
        ds.setPassword("qwer1234");

        controllerMap.put("/board/register", boardController);
        controllerMap.put("/board/read", boardController);

        controllerMap.put("/user/signup", userController);
        controllerMap.put("/user/login", userController);
        controllerMap.put("/chat", chatController);

        // 명함 조회 URI 맵핑
        controllerMap.put("/namecard/search", namecardSearchController);
        controllerMap.put("/namecard/create", namecardCreateController);

        // URI 맵핑
        controllerMap.put("/image/upload", imageController);
        controllerMap.put("/user/password/find", userController);
    }

    public Controller getController(String uri) {
        return controllerMap.get(uri);
    }
}
