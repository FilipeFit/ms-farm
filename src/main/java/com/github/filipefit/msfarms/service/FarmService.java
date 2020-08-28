package com.github.filipefit.msfarms.service;

import com.github.filipefit.msfarms.api.model.input.UpdateFarmAnimalsInputDTO;
import com.github.filipefit.msfarms.exception.FarmNotFoundException;
import com.github.filipefit.msfarms.model.City;
import com.github.filipefit.msfarms.model.Farm;
import com.github.filipefit.msfarms.repository.FarmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FarmService {

    private final FarmRepository farmRepository;
    private final CityService cityService;

    public FarmService(FarmRepository farmRepository, CityService cityService) {
        this.farmRepository = farmRepository;
        this.cityService = cityService;
    }

    @Transactional
    public Farm save(Farm farm) {

        Long cityId = farm.getAddress().getCity().getId();
        City city = cityService.findById(cityId);
        farm.getAddress().setCity(city);

        return farmRepository.save(farm);
    }

    public Farm findById(Long farmId){
        return farmRepository.findById(farmId).orElseThrow(
                () -> new FarmNotFoundException(farmId));
    }

    public List<Farm> findAll(){
        return farmRepository.findAll();
    }

    @Transactional
    public Farm updateFarmCapacity(Long farmId, Long capacity){
        Farm farm = findById(farmId);
        farmRepository.setNewFarmCapacity(farm.getId(), capacity);
        farmRepository.flush();
        farm = findById(farmId);
        return farm;
    }

    @Transactional
    public Farm updateFarmAnimalsAmount(Long farmId, UpdateFarmAnimalsInputDTO updateFarmAnimalsInputDTO){

        Farm farm = findById(farmId);
        Long newAnimalAMount = updateFarmAnimalsInputDTO.getOperation()
                .calculateAnimalAmount(updateFarmAnimalsInputDTO.getAnimalAmount(), farm);
        farmRepository.setNewFarmAnimalsAmount(farm.getId(), newAnimalAMount);
        farmRepository.flush();
        farm = findById(farmId);
        return farm;
    }

}
