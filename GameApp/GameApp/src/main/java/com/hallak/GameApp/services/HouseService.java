package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.HouseDTO;
import com.hallak.GameApp.dtos.HouseOddsDTO;
import com.hallak.GameApp.dtos.HouseRegisterDTO;
import com.hallak.GameApp.dtos.HouseReturnOfRegisterDTO;


public interface HouseService {
    HouseDTO getMe();
    HouseReturnOfRegisterDTO saveHouse(HouseRegisterDTO houseDTO);
    HouseOddsDTO newOdds(HouseOddsDTO houseDTO);

}
