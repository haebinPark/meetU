package com.example.codestates.mention.controller;

import com.example.codestates.mention.auth.PrincipalDetails;
import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.entity.User;
import com.example.codestates.mention.response.Response;
import com.example.codestates.mention.service.MentionService_Refactor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// 현재 작업 진행중 > 작업완료 후 기존파일 제거 및 이름변경 필요함
@RequiredArgsConstructor
@RestController
public class MentionController_Refactor {

    private final MentionService_Refactor mentionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(params = {"/mentions"})
    public Response<?> sendMention(@RequestBody MentionDto mentionDto, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        MentionDto savedMention = mentionService.writeMention(mentionDto, user);

        return new Response<>("성공", "쪽지를 보냈습니다.", savedMention);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(params = {"/mentions/sent/{mention_id}"})
    public Response<?> deleteReceivedMention(@PathVariable("mention_id") Long id, Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        MentionDto mentionDto = mentionService.findMentionById(user);
        MentionDto deletedMention = mentionService.deleteMentionByReceiver(mentionDto, user);

        return new Response<>("삭제 성공", "받은 쪽지인, " + id + "번 쪽지를 삭제했습니다.", deletedMention);
    }
}