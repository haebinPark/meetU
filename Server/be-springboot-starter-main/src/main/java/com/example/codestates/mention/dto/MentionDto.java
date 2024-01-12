package com.example.codestates.mention.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MentionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotEmpty
        private String sendContent;
        @Positive
        private Long senderUserId;
        @Positive
        private Long receiverUserId;
    }

    @Getter
    @Setter
    public static class Patch {
        private boolean read;
    }


    @Getter
    @Setter
    public static class Response {
        private Long mentionId;
        private String sendContent;
        private Long senderUserId;
        private String createdAt;
        private boolean isRead;

        @AllArgsConstructor
        @Getter
        @Setter
        public static class Sender {
            private Long mentionId;
            private String nickname;
        }

        public Response(Long mentionId, String sendContent, Long senderUserId, LocalDateTime createdAt, Boolean isRead) {
            this.mentionId = mentionId;
            this.sendContent = sendContent;
            this.senderUserId = senderUserId;
            this.createdAt = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            this.isRead = isRead;
        }
    }

    @AllArgsConstructor
    @Getter
    public static class NotReadResponse {
        private Long notReadCount;
    }

}