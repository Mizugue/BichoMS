package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.BetReceived;
import com.hallak.SettlementApp.dtos.BetReceivedFromBetByUsernameDTO;
import com.hallak.SettlementApp.dtos.ResultReceived;
import com.hallak.SettlementApp.dtos.SettlementDTO;
import com.hallak.SettlementApp.exceptions.exception.ResourceNotFoundException;
import com.hallak.SettlementApp.util.HandlerOfSettlement;
import feign.FeignException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public SettlementDTO doCorrectionByBetId(Long id) {
        BetReceived betReceived = new BetReceived();
        ResultReceived resultReceived = new ResultReceived();

        try {
            betReceived = betFeignClient.findById(id);
            resultReceived = resultFeignClient.findByGameId(betReceived.getGame().getId());
        } catch (FeignException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

        return handlerOfSettlement.process(betReceived, resultReceived);

    }

    @Override
    public List<SettlementDTO> doCorrectionByUsernameFromUser(String username) {
        List<BetReceivedFromBetByUsernameDTO> bets = betFeignClient.findAllByUsername(username);
        List<SettlementDTO> results = new ArrayList<>();

        for (BetReceivedFromBetByUsernameDTO bet : bets){
            results.add(doCorrectionByBetId(bet.getId()));
        }
        return results;

    }

}
