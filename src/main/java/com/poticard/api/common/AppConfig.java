package com.poticard.api.common;

import com.poticard.api.board.*;
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
        controllerMap.put("/user/password/find", userController);
    }

    public Controller getController(String uri) {
        return controllerMap.get(uri);
    }
}
