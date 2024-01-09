package com.example.codestates.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class CommentDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {
        private String context;
        private String nickname;
    }
    @Getter
    public static class Patch{
        private Long commentId;
        private String context;
        private String nickname;

        public void setContext(Long commentId){
            this.context =context;
        }
    }

}
