package com.example.demo.mockito;

import com.example.codestates.comment.controller.CommentController;
import com.example.codestates.comment.dto.CommentDto;
import com.example.codestates.comment.entity.Comment;
import com.example.codestates.comment.mapper.CommentMapper;
import com.example.codestates.comment.service.CommentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

// ...



@ExtendWith(MockitoExtension.class)
public class CommentControllerTest {

    @Mock
    private CommentService commentService;

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private CommentController commentController;

    private MockMvc mockMvc;
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }
    @Test
    public void testCreateComment() throws Exception {
        // MockMvc 인스턴스 설정
        mockMvc = MockMvcBuilders.standaloneSetup(commentController)
                .alwaysDo(document("{method-name}/{step}/"))
                .build();

        // 테스트 데이터 설정
        long bandId = 1;
        CommentDto.Post postDto = new CommentDto.Post("This is a test comment.", "tester");
        Comment comment = new Comment(1L, "This is a test comment.", "tester", null, null, null);

        // Mock 객체 설정
        given(commentMapper.commentPostDtoTocomment(any(CommentDto.Post.class))).willReturn(comment);
        given(commentService.createComment(any(Long.class), any(Comment.class))).willReturn(comment);

        // 테스트 실행
        mockMvc.perform(post("/comments")
                        .param("band_id", String.valueOf(bandId))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postDto)))
                .andExpect(status().isCreated())
                .andDo(document("create-comment",
                        requestParameters(
                                parameterWithName("band_id").description("The id of the band associated with the comment")
                        ),
                        requestFields(
                                fieldWithPath("context").description("The content of the comment"),
                                fieldWithPath("nickname").description("The nickname of the commenter")
                        ),
                        responseFields(
                                fieldWithPath("commentId").description("The ID of the newly created comment"),
                                fieldWithPath("context").description("The content of the comment"),
                                fieldWithPath("nickname").description("The nickname of the commenter")
                        )
                ));

        // Mock 객체의 메서드가 실행되었는지 확인
        verify(commentService).createComment(any(Long.class), any(Comment.class));
        verify(commentMapper).commentPostDtoTocomment(any(CommentDto.Post.class));
    }
}
