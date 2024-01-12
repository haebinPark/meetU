package com.example.codestates.mention.controller;


import com.example.codestates.mention.dto.SingleResponseDto;
import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.entity.Mention;
import com.example.codestates.mention.mapper.MentionMapper;
import com.example.codestates.mention.service.MentionService;
import com.example.codestates.mention.utils.UriCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/Mentions")
@RequiredArgsConstructor
@Validated
public class MentionController {

    private final MentionService MentionService;
    private final MentionMapper mapper;
    private final SseEmitter sseEmitters;

    @PostMapping
    public ResponseEntity postMention(@RequestBody MentionDto.Post requestBody) {
        Mention Mention = mapper.MentionPostToMention(requestBody);

        Mention createdMention = MentionService.createMention(Mention);
        URI location = UriCreator.createUri("/Mentions", createdMention.getMentionId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{mention-id}")
    public ResponseEntity getMention(@PathVariable("mention-id") Long MentionId) {
        Mention Mention = MentionService.findMention(MentionId);

        return ResponseEntity.ok(
            new SingleResponseDto<>(mapper.MentionToMentionResponse(Mention))
        );
    }

    @GetMapping
    public ResponseEntity getMentions(@RequestParam("mention-id") Long MentionId) {
        List<Mention> Mentions = MentionService.findMentions(MentionId);

        return ResponseEntity.ok(
            new SingleResponseDto<>(mapper.MentionsToMentionResponses(Mentions))
        );
    }

    @PatchMapping("/{mention-id}")
    public ResponseEntity patchMention(@PathVariable("mention-id") Long MentionId,
                                       @RequestBody MentionDto.Patch requestBody) {
        MentionService.changeMentionStatus(MentionId, requestBody.isRead());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{mention-id}")
    public ResponseEntity deleteMention(@PathVariable("mention-id") Long mentionId) {
        MentionService.deleteMention(mentionId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "not-read/{member-Id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect(@PathVariable("member-Id") @Positive Long memberId) {
        SseEmitter emitter = new SseEmitter(10 * 1000L);

//        sseEmitters.add(memberId, emitter);
//        sseEmitters.count(memberId);
        return ResponseEntity.ok(emitter);
    }
}