package com.example.codestates.mention.controller;

import com.example.codestates.mention.auth.PrincipalDetails;
import com.example.codestates.mention.dto.MentionDto;
import com.example.codestates.mention.entity.User;
import com.example.codestates.mention.repository.MentionRepository;
import com.example.codestates.mention.response.Response;
import com.example.codestates.mention.service.MentionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

// 기존코드 작업 후 삭제예정
@RequiredArgsConstructor
@RestController
public class MentionController {

    private final MentionService mentionService;
    private final MentionRepository mentionRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(params = {"/mentions"})
    public Response<?> sendMention(@RequestBody MentionDto mentionDto, Authentication authentication) {
        // 임의로 유저 정보를 넣었지만, JWT 도입하고 현재 로그인 된 유저의 정보를 넘겨줘야함
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        mentionDto.setSenderUserId(user.getId());

        return new Response<>("성공", "쪽지를 보냈습니다.", mentionService.write(mentionDto));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = {"/mentions/sent"})
    public Response<?> getReceivedMention(Authentication authentication) {
        // 임의로 유저 정보를 넣었지만, JWT 도입하고 현재 로그인 된 유저의 정보를 넘겨줘야함
        //        User user = userRepository.findById(14).orElseThrow(() -> {
        //            return new IllegalArgumentException("유저를 찾을 수 없습니다.");
        //        });

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        return new Response("성공", "받은 쪽지를 불러왔습니다.", mentionService.receivedMentions(user));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(params = {"/mentions/sent/{mention_id}"})
    public Response<?> deleteReceivedMention(@PathVariable("mention_id") Long id, Authentication authentication) {
        // 임의로 유저 정보를 넣었지만, JWT 도입하고 현재 로그인 된 유저의 정보를 넘겨줘야함
        //        User user = userRepository.findById(1).orElseThrow(() -> {
        //            return new IllegalArgumentException("유저를 찾을 수 없습니다.");
        //        });

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        MentionDto mentionDto = mentionService.findMentionById(user);

        if(mentionDto.getReceiveUserId().equals(user.getId())) {
            return new Response<>("삭제 성공", "받은 쪽지인, " + id + "번 쪽지를 삭제했습니다.", mentionService.deleteMentionByReceiver(mentionDto, user));
        } else {
            return new Response<>("삭제 실패", "사용자 정보가 다릅니다.", null);
        }

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(params = {"/mentions/sent/{user_id}"})
    public Response<?> getSendMention(Authentication authentication) {
        // 임의로 유저 정보를 넣었지만, JWT 도입하고 현재 로그인 된 유저의 정보를 넘겨줘야함
        //        User user = userRepository.findById(1).orElseThrow(() -> {
        //            return new IllegalArgumentException("유저를 찾을 수 없습니다.");
        //        });

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        return new Response("성공", "보낸 쪽지를 불러왔습니다.", mentionService.sendMention(user));
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(params = {"/mentions/sent/{mention_id}"})
    public Response<?> deleteMentionBySender(@PathVariable("mention_id") Long id, Authentication authentication) {
        // 임의로 유저 정보를 넣었지만, JWT 도입하고 현재 로그인 된 유저의 정보를 넘겨줘야함
        //        User user = userRepository.findById(1).orElseThrow(() -> {
        //            return new IllegalArgumentException("유저를 찾을 수 없습니다.");
        //        });

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        User user = principalDetails.getUser();

        MentionDto mentionDto = mentionService.findMentionById(user);

        if(mentionDto.getSenderUserId().equals(user.getId())) {
            return new Response<>("삭제 성공", "보낸 쪽지인, " + id + "번 쪽지를 삭제했습니다.", mentionService.deleteMentionBySender(mentionDto, user));
        } else {
            return new Response<>("삭제 실패", "사용자 정보가 다릅니다.", null);
        }
    }
}