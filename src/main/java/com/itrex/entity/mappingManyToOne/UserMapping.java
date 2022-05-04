package com.itrex.entity.mappingManyToOne;

import com.itrex.entity.PersonalInfo;
import com.itrex.entity.Role;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@ToString(exclude = "company")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users3", schema = "public")
@TypeDef(name = "itrex", typeClass = JsonBinaryType.class)
public class UserMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

    @Column(unique = true)
    private String username;

    @Type(type = "itrex")
    private String info;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(optional = false, fetch = FetchType.LAZY) //inner join, if optional =true (default - left join)
    @JoinColumn(name = "company_id") // company_id
    private Company company;
}
