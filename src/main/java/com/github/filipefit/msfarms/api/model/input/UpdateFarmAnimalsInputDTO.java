package com.github.filipefit.msfarms.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class UpdateFarmAnimalsInputDTO {

    @Enumerated(EnumType.STRING)
    private UpdateAnimalsOperation operation;
    @NotNull
    @Positive
    private Long animalAmount;

}
