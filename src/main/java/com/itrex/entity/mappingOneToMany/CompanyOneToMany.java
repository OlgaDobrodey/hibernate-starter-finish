package com.itrex.entity.mappingOneToMany;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    @org.hibernate.annotations.OrderBy(clause = "username DESC, lastname ASC")
    private List<UserOneToMany> userMappings = new ArrayList<>();

    public void addUser(UserOneToMany user) {
        userMappings.add(user);
        user.setCompanyOneToMany(this);
    }

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "company_locale", joinColumns = @JoinColumn(name = "company_id"))
//    @AttributeOverride(name = "lang", column = @Column(name = "language"))
//    private List<LocaleInfo> locales = new ArrayList<>();
    @Column(name = "description")
    private Set<String> locales = new TreeSet<>();

}
