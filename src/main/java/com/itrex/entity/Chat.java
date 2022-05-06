package com.itrex.entity;

import com.itrex.entity.manyTOManyReal.UserChat;
import com.itrex.entity.mappingOneToMany.UserOneToMany;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@ToString(exclude = "users")
@Builder
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

//    @Builder.Default
//    @ManyToMany(mappedBy = "chats")
//    private Set<UserOneToMany> users = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "chat")
    private Set<UserChat> userChats = new HashSet<>();

}

