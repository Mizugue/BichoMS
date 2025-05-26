package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.house.*;
import com.hallak.GameApp.models.BetType;

import java.util.List;


public interface HouseService {
    HouseDTO getMe();
    HouseReturnOfRegisterDTO saveHouse(HouseRegisterDTO houseDTO);
    HouseOddsDTO newOdds(HouseOddsDTO houseDTO);
    Double calculateAmount(String username, BetType betType, Double amount);
    List<HouseFromGISDTO> findAll();

}
