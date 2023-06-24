package sparta.sparta_spring_level_1.dto;

import lombok.Getter;
import lombok.Setter;
import sparta.sparta_spring_level_1.Entity.Post;
import sparta.sparta_spring_level_1.Entity.PostStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class PostRequest {

    private Long id;

    @NotEmpty(message = "제목을 써주셔야 합니다.")
    private String title;

    private String content;
    private String author;
    private String password;
    private LocalDateTime postDate;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .password(password)
                .build();
    }
}