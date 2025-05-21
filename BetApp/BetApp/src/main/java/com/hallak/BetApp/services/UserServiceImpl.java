package com.hallak.BetApp.services;


import com.hallak.BetApp.dtos.user.UserAuthDTO;
import com.hallak.BetApp.dtos.user.UserDTO;
import com.hallak.BetApp.dtos.user.UserReturnOfAuthDTO;
import com.hallak.BetApp.models.Role;
import com.hallak.BetApp.models.User;
import com.hallak.BetApp.repositories.RoleRepository;
import com.hallak.BetApp.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final AuthenticatedUserService authenticatedUserService;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, AuthenticatedUserService authenticatedUserService, PasswordEncoder passwordEncoder, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.authenticatedUserService = authenticatedUserService;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> result = userRepository.findByUsername(username);
        if (result.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return result.get();
    }


    @Override
    public UserDTO getMe() {
        /*User user = authenticatedUserService.authenticated();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setBets(user.getBets().stream().map(x -> modelMapper.map(x, BetDTO.class)).collect(Collectors.toSet()));
        return userDTO;*/
        return modelMapper.map(authenticatedUserService.authenticated(), UserDTO.class);
    }

    @Override
    public UserReturnOfAuthDTO newUser(UserAuthDTO userAuthDTO) {
        User user = modelMapper.map(userAuthDTO, User.class);
        user.setPassword(passwordEncoder.encode(userAuthDTO.getPassword()));
        Optional<Role> role = roleRepository.findById(1L);
        role.ifPresent(user::setRoles);
        return modelMapper.map(userRepository.save(user), UserReturnOfAuthDTO.class);

        }
    }



