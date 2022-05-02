package com.itrex.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users2", schema = "public")
@TypeDef(name = "itrex", typeClass = JsonBinaryType.class)
public class User2 {

    @EmbeddedId
    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo2 personalInfo;

    @Column(unique = true)
    private String username;

    @Type(type = "itrex")
    private String info;

    @Enumerated(EnumType.STRING)
    private Role role;
}
