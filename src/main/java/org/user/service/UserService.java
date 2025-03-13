package org.user.service;

import org.user.domain.UserDomain;
import org.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.user.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void addUser(UserDomain userDomain) {
        userRepository.save(userMapper.toEntity(userDomain));
    }

    public UserDomain getUser(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDomain)
                .orElse(null);
    }
}



