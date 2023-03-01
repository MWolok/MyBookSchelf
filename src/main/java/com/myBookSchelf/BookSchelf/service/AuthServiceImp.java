package com.myBookSchelf.BookSchelf.service;

import com.myBookSchelf.BookSchelf.dto.LoginDto;
import com.myBookSchelf.BookSchelf.dto.UserRegisterDto;
import com.myBookSchelf.BookSchelf.exception.BookApiException;
import com.myBookSchelf.BookSchelf.model.Role;
import com.myBookSchelf.BookSchelf.model.User;
import com.myBookSchelf.BookSchelf.repository.RoleRepository;
import com.myBookSchelf.BookSchelf.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImp implements AuthoService{
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository repository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;
    private  RoleRepository roleRepository;

//    public AuthServiceImp(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }


    public AuthServiceImp(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository repository, PasswordEncoder passwordEncoder, ModelMapper modelMapper,RoleRepository roleRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.roleRepository =roleRepository;
    }

    @Override
    public Optional<Long> login(LoginDto loginDto) {
      Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
     Optional<User> usr= userRepository.findByUsernameOrEmail(loginDto.getUsernameOrEmail(),loginDto.getUsernameOrEmail());
        return  usr.map(user -> user.getId());
    }

    @Override
    public String userRole(long id) {
    return   null;
    }

    @Override
    public String register(UserRegisterDto registerDto) {
        //check username
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new BookApiException(HttpStatus.BAD_REQUEST, "User alredy exists.");
        }
        if (userRepository.existsByEmail(registerDto.getEmail())){
            throw new BookApiException(HttpStatus.BAD_REQUEST, "Email alredy exists.");
        }
        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        //By default each registered user gets a role user
        Set<Role> roles = new HashSet<>();
        Role userRole = repository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User Register successfully";
    }
    private UserRegisterDto userToDto(User user){
        UserRegisterDto dto = modelMapper.map(user, UserRegisterDto.class);
        return dto;
    }
    private User dtoToUser(UserRegisterDto userRegisterDto){
        User user = modelMapper.map(userRegisterDto, User.class);
        return user;
    }
}
