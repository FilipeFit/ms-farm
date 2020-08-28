package com.github.filipefit.msfarms.api.model.input;

import com.github.filipefit.msfarms.exception.NotEnoughFarmCapacityException;
import com.github.filipefit.msfarms.model.Farm;

public enum UpdateAnimalsOperation {
    ADD {
        @Override
        public Long calculateAnimalAmount(Long animalsAmount, Farm farm) {
            if ((animalsAmount + farm.getAnimalAmount()) > farm.getAnimalCapacity()) {
                throw new NotEnoughFarmCapacityException(
                        String.format("The max capacity of the fam is %d the farm does not have capacity for %d animals"
                                , farm.getAnimalCapacity(), animalsAmount));
            }
            return animalsAmount + farm.getAnimalAmount();
        }
    },
    SUBTRACT {
        @Override
        public Long calculateAnimalAmount(Long animalsAmount, Farm farm) {
            if ((farm.getAnimalAmount() - animalsAmount) < 0) {
                throw new NotEnoughFarmCapacityException(
                        String.format("There is not enough animals in the farm (%d) for this operation (%d)"
                                , farm.getAnimalAmount(), animalsAmount));
            }
            return farm.getAnimalAmount() - animalsAmount;
        }
    };

    public abstract Long calculateAnimalAmount(Long animalsAmount, Farm farm);

}
