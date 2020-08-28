package com.github.filipefit.msfarms.repository;

import com.github.filipefit.msfarms.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
