package com.hallak.BetApp.services;

import com.hallak.BetApp.dtos.user.UserAuthDTO;
import com.hallak.BetApp.dtos.user.UserDTO;
import com.hallak.BetApp.dtos.user.UserReturnOfAuthDTO;

public interface UserService {
    UserDTO getMe();
    UserReturnOfAuthDTO newUser(UserAuthDTO userAuthDTO);
}
