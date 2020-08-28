package com.github.filipefit.msfarms.api.model.mapper;

import com.github.filipefit.msfarms.api.model.input.CityInputDTO;
import com.github.filipefit.msfarms.model.City;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CityInputMapper {

    private final ModelMapper modelMapper;

    public CityInputMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public City toDomainObject(CityInputDTO cityInputDTO) {
        return modelMapper.map(cityInputDTO, City.class);
    }

    public void copyToDomainObject(CityInputDTO cityInputDTO, City city) {
        modelMapper.map(cityInputDTO, city);
    }

}
