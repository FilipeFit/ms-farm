package com.github.filipefit.msfarms.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AddressInputDTO {

    @NotEmpty
    private String road;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String number;

    private String complement;
    @Valid
    @NotNull
    private CityIdInputDTO city;
}
