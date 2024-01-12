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
        MentionService.findMention(Mention.getSenderUserId().getId());
        MentionService.findMention(Mention.getReceiveUserId().getId());
        Mention savedMention = MentionRepository.save(Mention);
        sseEmitters.count(Mention.getReceiveUserId().getId());
        return savedMention;
    }

    @Transactional
    public Mention findMention(Long MentionId) {
        Mention findMention = findVerifiedMention(MentionId);
        findMention.checkMention();
        sseEmitters.count(findMention.getReceiveUserId().getId());
        return findMention;
    }

    public List<Mention> findMentions(Long Id) {
        return MentionRepository.findByReceiverMentionId(Id);
    }

    @Transactional
    public void changeMentionStatus(Long Id, boolean read) {
        Mention Mention = findVerifiedMention(Id);
        Mention.setRead(read);
        sseEmitters.count(Mention.getReceiveUserId().getId());
    }

    @Transactional
    public void deleteMention(Long Id) {
        MentionRepository.deleteById(Id);
    }

    private Mention findVerifiedMention(Long Id) {
        Optional<Mention> optionalMention = MentionRepository.findById(Id);
        Mention findMention = optionalMention.orElseThrow(
            () -> new BusinessLogicException(ExceptionCode.MENTION_NOT_FOUND)
        );
        return findMention;
    }
}