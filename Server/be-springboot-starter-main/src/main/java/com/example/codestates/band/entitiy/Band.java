package com.example.codestates.band.entitiy;

import com.example.codestates.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bandId;//여기부분이 id로 작성되어있엇고 GeneratedValue도 제대로 안되어 있어서 수정했습니다. 근데 이제는 종료코드1로 종료되어 버려요..

    @OneToMany(mappedBy = "band")
    private List<Comment> comments = new ArrayList<>();

}