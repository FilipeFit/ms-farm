package com.github.filipefit.msfarms.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CityIdInputDTO {

    @NotNull
    private Long id;
}
