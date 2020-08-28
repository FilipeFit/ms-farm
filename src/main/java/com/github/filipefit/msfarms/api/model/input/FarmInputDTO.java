package com.github.filipefit.msfarms.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FarmInputDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    @NotNull
    private Long animalCapacity;
    @NotNull
    private Long animalAmount;
    @Valid
    @NotNull
    private AddressInputDTO address;

}
