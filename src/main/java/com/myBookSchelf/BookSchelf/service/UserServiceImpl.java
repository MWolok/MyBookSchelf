package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.UserDto;
import com.myBookSchelf.BookSchelf.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.myBookSchelf.BookSchelf.repository.UserModelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
private ModelMapper modelMapper;
private UserModelRepository userModelRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserModelRepository userModelRepository) {
        this.modelMapper = modelMapper;
        this.userModelRepository = userModelRepository;
    }
    private UserDto userToDto(UserModel user){
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }
    private UserModel dtoToUser(UserDto userDto){
        UserModel userModel = modelMapper.map(userDto, UserModel.class);
        return userModel;
    }

    @Override
    public List<UserDto> getAllUsers() {
      List<UserModel> listUsers=  userModelRepository.findAll();
     return listUsers.stream().map(user->userToDto(user)).collect(Collectors.toList());
    }
}
