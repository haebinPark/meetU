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
//    private final SseEmitter sseEmitters;

    @PostMapping
    public ResponseEntity postMention(@RequestBody MentionDto.Post requestBody) {
        Mention Mention = mapper.MentionPostToMention(requestBody);

        Mention createdMention = MentionService.createMention(Mention);
        URI location = UriCreator.createUri("/Mentions", createdMention.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getMention(@PathVariable("id") Long Id) {
        Mention Mention = MentionService.findMention(Id);

        return ResponseEntity.ok(
            new SingleResponseDto<>(mapper.MentionToMentionResponse(Mention))
        );
    }

    @GetMapping
    public ResponseEntity getMentions(@RequestParam("id") Long Id) {
        List<Mention> Mentions = MentionService.findMentions(Id);

        return ResponseEntity.ok(
            new SingleResponseDto<>(mapper.MentionsToMentionResponses(Mentions))
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchMention(@PathVariable("id") Long Id,
                                       @RequestBody MentionDto.Patch requestBody) {
        MentionService.changeMentionStatus(Id, requestBody.isRead());

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMention(@PathVariable("id") Long Id) {
        MentionService.deleteMention(Id);

        return ResponseEntity.noContent().build();
    }

    // ** /not-read/{id}
    @GetMapping(value = "{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect(@PathVariable("id") @Positive Long Id) {
        SseEmitter emitter = new SseEmitter(10 * 1000L);
//        오류확인 필요
//        sseEmitters.add(Id, emitter);
//        sseEmitters.count(Id);
        return ResponseEntity.ok(emitter);
    }
}