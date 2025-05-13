package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.House.HouseDTO;
import com.hallak.GameApp.dtos.House.HouseOddsDTO;
import com.hallak.GameApp.dtos.House.HouseRegisterDTO;
import com.hallak.GameApp.dtos.House.HouseReturnOfRegisterDTO;


public interface HouseService {
    HouseDTO getMe();
    HouseReturnOfRegisterDTO saveHouse(HouseRegisterDTO houseDTO);
    HouseOddsDTO newOdds(HouseOddsDTO houseDTO);

}
