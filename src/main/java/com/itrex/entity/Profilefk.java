package com.itrex.entity;

import com.itrex.entity.mappingOneToMany.UserOneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profilefk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;
    private String street;
    private String language;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserOneToMany user;

    public void setUser(UserOneToMany user) {
        user.setProfilefk(this);
        this.user = user;
     }

}
