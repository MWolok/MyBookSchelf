package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserDto;
import com.myBookSchelf.BookSchelf.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.myBookSchelf.BookSchelf.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
private ModelMapper modelMapper;
private UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }
    private UserDto userToDto(User user){
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
    private User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    @Override
    public List<UserDto> getAllUsers() {
      List<User> listUsers=  userRepository.findAll();
     return listUsers.stream().map(user->userToDto(user)).collect(Collectors.toList());
    }
}
