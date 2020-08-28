package com.github.filipefit.msfarms.api.controller;

import com.github.filipefit.msfarms.api.model.input.CityInputDTO;
import com.github.filipefit.msfarms.api.model.mapper.CityInputMapper;
import com.github.filipefit.msfarms.api.model.mapper.CityOutputMapper;
import com.github.filipefit.msfarms.api.model.output.CityOutputDTO;
import com.github.filipefit.msfarms.model.City;
import com.github.filipefit.msfarms.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityService cityService;
    private final CityInputMapper cityInputMapper;
    private final CityOutputMapper cityOutputMapper;

    public CityController(CityService cityService, CityInputMapper cityInputMapper, CityOutputMapper cityOutputMapper) {
        this.cityService = cityService;
        this.cityInputMapper = cityInputMapper;
        this.cityOutputMapper = cityOutputMapper;
    }

    @GetMapping
    public List<CityOutputDTO> getAll() {
        List<City> cities = cityService.findAll();
        return cityOutputMapper.toOutputDTOList(cities);
    }

    @GetMapping("/{cityId}")
    public CityOutputDTO findById(@PathVariable Long cityId) {
        City city = cityService.findById(cityId);
        return cityOutputMapper.toOutputDTO(city);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityOutputDTO save(@RequestBody @Valid CityInputDTO cityInputDTO) {
        City city = cityInputMapper.toDomainObject(cityInputDTO);
        city = cityService.save(city);
        return cityOutputMapper.toOutputDTO(city);
    }

    @PutMapping("/{cityId}")
    public CityOutputDTO update(@PathVariable Long cityId,
                                @RequestBody @Valid CityInputDTO cityInputDTO) {
        City currentCity = cityService.findById(cityId);
        cityInputMapper.copyToDomainObject(cityInputDTO, currentCity);
        currentCity = cityService.save(currentCity);
        return cityOutputMapper.toOutputDTO(currentCity);
    }

    @DeleteMapping("/{cityId}")
    public void remove(@PathVariable Long cityId) {
        cityService.delete(cityId);
    }

}
