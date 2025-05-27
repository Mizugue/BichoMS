package com.hallak.SettlementApp.services;

import com.hallak.SettlementApp.dtos.SettlementDTO;

import java.util.List;

public interface SettlementService {
    SettlementDTO doCorrectionByBetId(Long id);
    List<SettlementDTO> doCorrectionByUsernameFromUser(String username);







}
