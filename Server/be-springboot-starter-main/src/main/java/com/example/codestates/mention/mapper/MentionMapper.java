package com.example.codestates.mention.mapper;

import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.entity.Mention;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface MentionMapper {


    @Mapping(source = "sendUserId", target = "senderUserId")
    @Mapping(source = "receiveUserId", target = "receiverUserId")
    Mention MentionPostToMention(MentionDto.Post requestBody);

    @Mapping(source = "sender.Id", target = "sender.id")
    @Mapping(source = "sender.nickname", target = "sender.nickname")
    MentionDto.Response MentionToMentionResponse(Mention Mention);

    List<MentionDto.Response> MentionsToMentionResponses(List<Mention> Mentions);
}
