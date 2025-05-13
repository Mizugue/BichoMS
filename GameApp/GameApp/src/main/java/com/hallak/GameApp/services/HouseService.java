package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.house.HouseDTO;
import com.hallak.GameApp.dtos.house.HouseOddsDTO;
import com.hallak.GameApp.dtos.house.HouseRegisterDTO;
import com.hallak.GameApp.dtos.house.HouseReturnOfRegisterDTO;


public interface HouseService {
    HouseDTO getMe();
    HouseReturnOfRegisterDTO saveHouse(HouseRegisterDTO houseDTO);
    HouseOddsDTO newOdds(HouseOddsDTO houseDTO);

}
