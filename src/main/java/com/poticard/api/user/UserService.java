package com.poticard.api.user;

import com.poticard.api.user.model.UserDto;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto signup(UserDto dto) {
        if (dto == null) return null;
        if (isBlank(dto.getEmail()) || isBlank(dto.getName()) || isBlank(dto.getPassword())) return null;

        UserDto exists = userRepository.findByEmail(dto.getEmail());
        if (exists != null) return null;

        return userRepository.create(dto);
    }

    public UserDto login(String email, String password) {
        if (isBlank(email) || isBlank(password)) return null;
        return userRepository.findByEmailAndPassword(email, password);
    }

    // ✅ 추가(컨트롤러에서 find용)
    public UserDto findByEmail(String email) {
        if (isBlank(email)) return null;
        return userRepository.findByEmail(email);
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
