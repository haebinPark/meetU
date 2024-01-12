package com.example.codestates.mention.service;

import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.entity.User;
import com.example.codestates.mention.repository.MentionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MentionService_Refactor {

    private final MentionRepository mentionRepository;

    public MentionDto writeMention(MentionDto mentionDto, User user) {
        mentionDto.setSenderUserId(user.getId());
        return mentionRepository.save(mentionDto);
    }

    public MentionDto deleteMentionByReceiver(MentionDto mentionDto, User user) {
        if(mentionDto.getReceiveUserId().equals(user.getId())) {
            mentionRepository.delete(mentionDto);
            return mentionDto;
        } else {
            throw new IllegalArgumentException("사용자의 정보가 다릅니다.");
        }
    }

    public MentionDto deleteMentionBySender(MentionDto mentionDto, User user) {
        if(mentionDto.getSenderUserId().equals(user.getId())) {
            mentionRepository.delete(mentionDto);
            return mentionDto;
        } else {
            throw new IllegalArgumentException("사용자의 정보가 다릅니다.");
        }
    }

    public MentionDto findMentionById(User user) {
    }
}