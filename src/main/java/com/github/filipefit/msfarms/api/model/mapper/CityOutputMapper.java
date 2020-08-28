package com.github.filipefit.msfarms.api.model.mapper;

import com.github.filipefit.msfarms.api.model.output.CityOutputDTO;
import com.github.filipefit.msfarms.model.City;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityOutputMapper {

    private final ModelMapper modelMapper;

    public CityOutputMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CityOutputDTO toOutputDTO(City city) {
        return modelMapper.map(city, CityOutputDTO.class);
    }

    public List<CityOutputDTO> toOutputDTOList(List<City> cities) {
        return cities.stream().map(city -> {
            return toOutputDTO(city);
        }).collect(Collectors.toList());
    }
}
