package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;
import com.hallak.SettlementApp.util.HandlerOfProcess;
import com.hallak.SettlementApp.util.HandlerOfSettlement;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class SettlementServiceImpl implements SettlementService{

    private ResultFeignClient resultFeignClient;
    private BetFeignClient betFeignClient;
    private ModelMapper modelMapper;
    private HandlerOfSettlement handlerOfSettlement;


    @Autowired
    public SettlementServiceImpl(ResultFeignClient resultFeignClient, BetFeignClient betFeignClient, ModelMapper modelMapper, HandlerOfSettlement handlerOfSettlement){
        this.resultFeignClient = resultFeignClient;
        this.betFeignClient = betFeignClient;
        this.modelMapper = modelMapper;
        this.handlerOfSettlement = handlerOfSettlement;


    }





    @Override
    public SettlementDTO doCorrection(Long id) {
        BetReceived betReceived = new BetReceived();
        ResultReceived resultReceived = new ResultReceived();
        try {
            betReceived = betFeignClient.findById(id);
            System.out.println(betReceived);
            resultReceived = resultFeignClient.findByGameId(betReceived.getGame().getId());
        } catch (FeignException e) {
            throw new ResourceAccessException(e.getMessage());
        }

        return handlerOfSettlement.process(betReceived, resultReceived);



    }

}
