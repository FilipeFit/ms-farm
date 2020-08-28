package com.github.filipefit.msfarms.api.model.output;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class FarmOutputDTO {

    private Long id;
    private String name;
    private String type;
    private Long animalCapacity;
    private Long animalAmount;
    private OffsetDateTime insertDate;
    private OffsetDateTime updateDate;
    private AddressOutputDTO address;

}
