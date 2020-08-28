package com.github.filipefit.msfarms.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class CityInputDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String state;
}
