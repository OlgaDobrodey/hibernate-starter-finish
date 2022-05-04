package com.itrex.entity.mappingOneToMany;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "userMappings")
@EqualsAndHashCode(exclude = "userMappings")
@Builder
@Entity
@Table(name = "company1", schema = "public")
public class CompanyOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "companyOneToMany", cascade = CascadeType.ALL)
//    @JoinColumn(name = "company_id")
    private List<UserOneToMany> userMappings = new ArrayList<>();

    public void addUser(UserOneToMany user){
        userMappings.add(user);
        user.setCompanyOneToMany(this);
    }

}
