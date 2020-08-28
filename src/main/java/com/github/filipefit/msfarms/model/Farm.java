package com.github.filipefit.msfarms.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "farm")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Farm {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private FarmType type;

    @Column(name = "animal_capacity", nullable = false)
    private Long animalCapacity;
    @Column(name = "animal_amount", nullable = false)
    private Long animalAmount;

    @CreationTimestamp
    @Column(name = "insert_date", nullable = false)
    private OffsetDateTime insertDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private OffsetDateTime updateDate;

    @Embedded
    private Address address;
}