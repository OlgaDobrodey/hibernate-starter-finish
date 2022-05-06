package com.itrex.entity.manyTOManyReal;

import com.itrex.entity.Chat;
import com.itrex.entity.User;
import com.itrex.entity.mappingOneToMany.UserOneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users_chat")
public class UserChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserOneToMany user;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    private Instant createdAt;

    private String createdBy;

    public void setUser(UserOneToMany user) {
        this.user = user;
        this.user.getUserChats().add(this);
    }

    public void setChat(Chat chat) {
        this.chat = chat;
        this.chat.getUserChats().add(this);
    }
}
