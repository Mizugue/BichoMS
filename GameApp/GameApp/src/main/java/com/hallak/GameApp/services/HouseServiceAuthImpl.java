package com.hallak.GameApp.services;

import com.hallak.GameApp.dtos.house.*;
import com.hallak.GameApp.exceptions.exception.InvalidArgumentException;
import com.hallak.GameApp.exceptions.exception.ResourceNotFoundException;
import com.hallak.GameApp.models.BetType;
import com.hallak.GameApp.models.House;
import com.hallak.GameApp.models.Role;
import com.hallak.GameApp.repositories.HouseRepository;
import com.hallak.GameApp.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
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
                throw new InvalidArgumentException("Invalid value: " + e.getLocalizedMessage());
                }
        }
        houseLogged.setOdds(convertedOdds);
        return modelMapper.map(houseRepository.save(houseLogged), HouseOddsDTO.class);

    }

    @Override
    public Double calculateAmount(String username, BetType betType, Double amount) {
        House house = houseRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("Invalid username"));
        BigDecimal odd = house.getOdds().get(betType);

        return amount * odd.doubleValue();
    }

    @Override
    public List<HouseFromGISDTO> findAll() {
        return houseRepository.findAll().stream().map(x -> modelMapper.map(x, HouseFromGISDTO.class)).toList();
    }


}






