package com.example.codestates.mention.entity;

import lombok.Getter;
import lombok.Setter;
import com.example.codestates.mention.audit.Auditable;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Mention extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentionId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String sendContent;

    private boolean isRead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senduser_id")
    private Mention senderUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiveuser_id")
    private Mention receiveUserId;

    public boolean getIsRead() {
        return isRead;
    }

    public void checkMention() {
        this.isRead = true;
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Mention> mentions = new ArrayList<>();
}