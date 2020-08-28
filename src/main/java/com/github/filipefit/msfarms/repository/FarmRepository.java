package com.github.filipefit.msfarms.repository;

import com.github.filipefit.msfarms.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {

    @Modifying
    @Query("update Farm fm set fm.animalCapacity = :farmCapacity where fm.id = :farmId")
    Integer setNewFarmCapacity(@Param("farmId")Long farmId, @Param("farmCapacity") Long farmCapacity);

    @Modifying
    @Query("update Farm fm set fm.animalAmount = :animalsAmount where fm.id = :farmId")
    Integer setNewFarmAnimalsAmount(@Param("farmId")Long farmId, @Param("animalsAmount") Long animalsAmount);
}
