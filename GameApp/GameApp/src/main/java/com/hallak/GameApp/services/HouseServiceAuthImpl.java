package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.HouseDTO;
import com.hallak.GameApp.dtos.HouseOddsDTO;
import com.hallak.GameApp.dtos.HouseRegisterDTO;
import com.hallak.GameApp.dtos.HouseReturnOfRegisterDTO;
import com.hallak.GameApp.models.BetType;
import com.hallak.GameApp.models.House;
import com.hallak.GameApp.models.Role;
import com.hallak.GameApp.repositories.HouseRepository;
import com.hallak.GameApp.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class HouseServiceAuthImpl implements UserDetailsService, HouseService {


    private final HouseRepository houseRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticatedHouseService authenticatedHouseService;

    @Autowired
    public HouseServiceAuthImpl(HouseRepository houseRepository, ModelMapper modelMapper, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticatedHouseService authenticatedHouseService) {
        this.houseRepository = houseRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticatedHouseService = authenticatedHouseService;

    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<House> result = houseRepository.findByUsername(username);
        if (result.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        return result.get();
    }


    @Transactional(readOnly = true)
    public HouseDTO getMe(){
        return modelMapper.map(authenticatedHouseService.authenticated(), HouseDTO.class);
    }

    @Override
    public HouseReturnOfRegisterDTO saveHouse(HouseRegisterDTO houseDTO) {
        House house = modelMapper.map(houseDTO, House.class);
        house.setPassword(passwordEncoder.encode(houseDTO.getPassword()));
        Optional<Role> role = roleRepository.findById(1L);
        role.ifPresent(house::setRoles);
        return modelMapper.map(houseRepository.save(house), HouseReturnOfRegisterDTO.class);

    }

    @Override
    public HouseOddsDTO newOdds(HouseOddsDTO houseDTO) {
        House houseLogged = authenticatedHouseService.authenticated();
        Map<BetType, BigDecimal> convertedOdds = new HashMap<>();
        for (Map.Entry<String, BigDecimal> entry : houseDTO.getOdds().entrySet()) {
            try {
                BetType betType = BetType.valueOf(entry.getKey().toUpperCase());
                convertedOdds.put(betType, entry.getValue());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid value");
                }
        }
        houseLogged.setOdds(convertedOdds);
        return modelMapper.map(houseRepository.save(houseLogged), HouseOddsDTO.class);

    }


}






