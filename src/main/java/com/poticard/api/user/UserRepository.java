package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;

public interface UserRepository {
    UserDto findByEmail(String email);
    UserDto findByEmailAndPassword(String email, String password);
    UserDto create(UserDto dto);
}