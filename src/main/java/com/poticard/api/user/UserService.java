package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto.LoginRes login (UserDto.LoginReq reqDto){
        UserDto.LoginRes dto = userRepository.login(reqDto);
        return dto;
    }
}
