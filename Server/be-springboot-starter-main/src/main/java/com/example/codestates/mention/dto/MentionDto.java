package com.example.codestates.mention.dto;

import com.example.codestates.mention.entity.Mention;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentionDto extends Mention {
    private Long id;
    private String sendContent;
    private Long senderUserId;
    private Long receiveUserId;


    public static MentionDto toDto(Mention mention) {
        return new MentionDto(
                mention.getId(),
                mention.getSendContent(),
                mention.getSenderUserId().getId(),
                mention.getReceiveUserId().getId()
        );
    }
}