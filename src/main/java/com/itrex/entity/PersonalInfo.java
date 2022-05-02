package com.itrex.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {

    private String firstname;
    private String lastname;

    //    @Convert(converter = BirthdayConverter.class)
//    @Column(name = "birth_date")
    private Birthday birthDate;
}
