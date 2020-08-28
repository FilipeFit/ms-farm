package com.github.filipefit.msfarms.api.controller;

import com.github.filipefit.msfarms.api.model.input.FarmInputDTO;
import com.github.filipefit.msfarms.api.model.input.FarmUpdateDTO;
import com.github.filipefit.msfarms.api.model.input.UpdateFarmAnimalsInputDTO;
import com.github.filipefit.msfarms.api.model.mapper.FarmInputMapper;
import com.github.filipefit.msfarms.api.model.mapper.FarmOutputMapper;
import com.github.filipefit.msfarms.api.model.output.FarmOutputDTO;
import com.github.filipefit.msfarms.model.Farm;
import com.github.filipefit.msfarms.service.FarmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/farms", produces = MediaType.APPLICATION_JSON_VALUE)
public class FarmController {

    private final FarmService farmService;
    private final FarmInputMapper farmInputMapper;
    private final FarmOutputMapper farmOutputMapper;

    public FarmController(FarmService farmService, FarmInputMapper farmInputMapper, FarmOutputMapper farmOutputMapper) {
        this.farmService = farmService;
        this.farmInputMapper = farmInputMapper;
        this.farmOutputMapper = farmOutputMapper;
    }

    @GetMapping
    public List<FarmOutputDTO> getAll() {
        List<Farm> farms = farmService.findAll();
        return farmOutputMapper.toOutputDTOList(farms);
    }

    @GetMapping("/{farmId}")
    public FarmOutputDTO findById(@PathVariable Long farmId){
        Farm farm = farmService.findById(farmId);
        return farmOutputMapper.toOutputDTO(farm);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FarmOutputDTO save(@RequestBody @Valid FarmInputDTO farmInputDTO){
        Farm farm = farmInputMapper.toDomainObject(farmInputDTO);
        farm = farmService.save(farm);
        return farmOutputMapper.toOutputDTO(farm);
    }

    @PutMapping("/{farmId}")
    public FarmOutputDTO update(@PathVariable Long farmId,
                                @RequestBody @Valid FarmUpdateDTO farmUpdateDTO){
        Farm currentFarm = farmService.findById(farmId);
        farmInputMapper.copyToDomainObject(farmUpdateDTO, currentFarm);
        currentFarm = farmService.save(currentFarm);
        return farmOutputMapper.toOutputDTO(currentFarm);
    }

    @PostMapping("/{farmId}/update-capacity/{capacity}")
    public FarmOutputDTO updateFarmCapacity(@PathVariable Long farmId, @PathVariable Long capacity){
        Farm farm = farmService.updateFarmCapacity(farmId,capacity);

        return farmOutputMapper.toOutputDTO(farm);
    }

    @PostMapping("/{farmId}/update-animals")
    public FarmOutputDTO updateFarmAnimals(@PathVariable Long farmId,
                                           @RequestBody @Valid UpdateFarmAnimalsInputDTO updateFarmAnimalsInputDTO){

        Farm farm = farmService.updateFarmAnimalsAmount(farmId, updateFarmAnimalsInputDTO);
        return  farmOutputMapper.toOutputDTO(farm);
    }
}
