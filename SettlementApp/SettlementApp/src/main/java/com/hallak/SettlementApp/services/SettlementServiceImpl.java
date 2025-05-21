package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettlementServiceImpl implements SettlementService{

    private ResultFeignClient resultFeignClient;
    private BetFeignClient betFeignClient;
    private ModelMapper modelMapper;

    @Autowired
    public SettlementServiceImpl(ResultFeignClient resultFeignClient, BetFeignClient betFeignClient, ModelMapper modelMapper){
        this.resultFeignClient = resultFeignClient;
        this.betFeignClient = betFeignClient;
        this.modelMapper = modelMapper;

    }





    @Override
    public SettlementDTO doCorrection(Long id) {
        BetReceived betReceived = betFeignClient.findById(id);
        ResultReceived resultReceived = resultFeignClient.findByGameId(betReceived.getGame().getId());

        System.out.println(betReceived);
        System.out.println(resultReceived);
        return new SettlementDTO();




    }

}
