package com.github.filipefit.msfarms.service;

import com.github.filipefit.msfarms.exception.CityNotFoundException;
import com.github.filipefit.msfarms.exception.EntityInUseException;
import com.github.filipefit.msfarms.model.City;
import com.github.filipefit.msfarms.repository.CityRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private static final String MSG_CITY_IN_USE = "City of code %d is in use";

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Transactional
    public void delete(Long cityId) {
        try {
            cityRepository.deleteById(cityId);
            // Ensure that the JPA queue is clear
            cityRepository.flush();
        } catch (EmptyResultDataAccessException ex) {
            throw new CityNotFoundException(cityId);
        } catch (DataIntegrityViolationException ex) {
            throw new EntityInUseException(String.format(MSG_CITY_IN_USE, cityId));
        }
    }

    public City findById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException(cityId));
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }
}
