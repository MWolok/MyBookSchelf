package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
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
    private UserRegisterDto userToDto(User user){
        UserRegisterDto dto = modelMapper.map(user, UserRegisterDto.class);
        return dto;
    }
    private User dtoToUser(UserRegisterDto userRegisterDto){
        User user = modelMapper.map(userRegisterDto, User.class);
        return user;
    }

    @Override
    public List<UserRegisterDto> getAllUsers() {
      List<User> listUsers=  userRepository.findAll();
     return listUsers.stream().map(user->userToDto(user)).collect(Collectors.toList());
    }
}
