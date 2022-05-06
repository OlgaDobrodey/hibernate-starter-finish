package com.itrex.entity;

import com.itrex.entity.mappingOneToMany.UserOneToMany;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @Column(name = "user_id")
    private Long id;
    private String street;
    private String language;

    @OneToOne
//    @JoinColumn(name = "user_id")
    @PrimaryKeyJoinColumn
    private UserOneToMany user;

    public void setUser(UserOneToMany user) {
        user.setProfile(this);
        this.user = user;
        this.id = user.getId();
    }

}
