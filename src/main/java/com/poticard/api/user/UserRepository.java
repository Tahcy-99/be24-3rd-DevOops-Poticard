package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;

public interface UserRepository {
    public UserDto.LoginRes login(UserDto.LoginReq reqDto);
    public UserDto.SignupRes signup(UserDto.SignupReq reqDto);
}
