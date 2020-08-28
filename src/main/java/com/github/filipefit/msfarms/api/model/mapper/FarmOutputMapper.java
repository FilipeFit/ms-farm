package com.github.filipefit.msfarms.api.model.mapper;

import com.github.filipefit.msfarms.api.model.output.FarmOutputDTO;
import com.github.filipefit.msfarms.model.Farm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FarmOutputMapper {

    private final ModelMapper modelMapper;

    public FarmOutputMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FarmOutputDTO toOutputDTO(Farm farm) {
        return modelMapper.map(farm, FarmOutputDTO.class);
    }

    public List<FarmOutputDTO> toOutputDTOList(List<Farm> farms) {
        return farms.stream().map(farm -> {
            return toOutputDTO(farm);
        }).collect(Collectors.toList());
    }
}

