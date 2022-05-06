package com.itrex.entity.mappingOneToMany;

import com.itrex.entity.PersonalInfo;
import com.itrex.entity.Profile;
import com.itrex.entity.Profilefk;
import com.itrex.entity.Role;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@ToString(exclude ={ "companyOneToMany","profile"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users4", schema = "public")
@TypeDef(name = "itrex", typeClass = JsonBinaryType.class)
public class UserOneToMany {

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST})
    @JoinColumn(name = "company_id") // company_id
    private CompanyOneToMany companyOneToMany;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    @OneToOne(mappedBy = "user")
    private Profilefk profilefk;

}
