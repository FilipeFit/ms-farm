package com.github.filipefit.msfarms.api.model.mapper;

import com.github.filipefit.msfarms.api.model.input.FarmInputDTO;
import com.github.filipefit.msfarms.api.model.input.FarmUpdateDTO;
import com.github.filipefit.msfarms.model.Farm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FarmInputMapper {

    private final ModelMapper modelMapper;

    public FarmInputMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Farm toDomainObject(FarmInputDTO FarmInputDTO) {
        return modelMapper.map(FarmInputDTO, Farm.class);
    }

    public void copyToDomainObject(FarmUpdateDTO farmUpdateDTO, Farm farm) {
        modelMapper.map(farmUpdateDTO, farm);
    }
}
