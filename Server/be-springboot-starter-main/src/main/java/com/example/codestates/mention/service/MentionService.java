package com.example.codestates.mention.service;

import com.example.codestates.mention.entity.Mention;
import com.example.codestates.mention.exception.BusinessLogicException;
import com.example.codestates.mention.exception.ExceptionCode;
import com.example.codestates.mention.repository.MentionRepository;
import com.example.codestates.mention.sse.SseEmitters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MentionService {
    private final MentionRepository MentionRepository;
    private final MentionService MentionService;
    private final SseEmitters sseEmitters;

    @Transactional
    public Mention createMention(Mention Mention) {
        MentionService.findMention(Mention.getSenderUserId().getMentionId());
        MentionService.findMention(Mention.getReceiveUserId().getMentionId());
        Mention savedMention = MentionRepository.save(Mention);
        sseEmitters.count(Mention.getReceiveUserId().getMentionId());
        return savedMention;
    }

    @Transactional
    public Mention findMention(Long MentionId) {
        Mention findMention = findVerifiedMention(MentionId);
        findMention.checkMention();
        sseEmitters.count(findMention.getReceiveUserId().getMentionId());
        return findMention;
    }

    public List<Mention> findMentions(Long mentionId) {
        return MentionRepository.findByReceiveUserId(mentionId);
    }

    @Transactional
    public void changeMentionStatus(Long Id, boolean read) {
        Mention Mention = findVerifiedMention(Id);
        Mention.setRead(read);
        sseEmitters.count(Mention.getReceiveUserId().getMentionId());
    }

    @Transactional
    public void deleteMention(Long MentionId) {
        MentionRepository.deleteById(MentionId);
    }

    private Mention findVerifiedMention(Long MentionId) {
        Optional<Mention> optionalMention = MentionRepository.findById(MentionId);
        Mention findMention = optionalMention.orElseThrow(
            () -> new BusinessLogicException(ExceptionCode.MENTION_NOT_FOUND)
        );
        return findMention;
    }
}