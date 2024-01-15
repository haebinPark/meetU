package com.example.codestates.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

public class CommentDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        @NotNull
        private String context;
        private String nickname;
    }
    @Getter
    public class Patch{
        private Long commentId;
        private String context;

        public void setContext(Long commentId){
            this.context =context;
        }
    }

}
