package com.example.codestates.mention.sse;

import com.example.codestates.mention.dto.SingleResponseDto;
import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.repository.MentionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SseEmitters {
    private final Map<Long, SseEmitter> emitterMap = new ConcurrentHashMap<>();
    private final MentionRepository MentionRepository;

    public SseEmitters(MentionRepository MentionRepository) {
        this.MentionRepository = MentionRepository;
    }

    public SseEmitter add(Long Id, SseEmitter emitter) {
        this.emitterMap.put(Id, emitter);
        emitter.onCompletion(() -> {
            this.emitterMap.remove(Id);
        });
        emitter.onTimeout(() -> {
            emitter.complete();
        });
        return emitter;
    }

    public void count(Long receiveuserId) {
        Long notReadCount = MentionRepository.countByReceiverMentionIdAndIsReadFalse(receiveuserId);
        try {
            if (emitterMap.containsKey(receiveuserId)) {
                emitterMap.get(receiveuserId)
                        .send(SseEmitter.event()
                            .name("notReadCount")
                            .data(new SingleResponseDto<>(new MentionDto.NotReadResponse(notReadCount))));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
