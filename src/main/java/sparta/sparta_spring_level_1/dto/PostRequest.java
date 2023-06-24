package sparta.sparta_spring_level_1.dto;

import lombok.Getter;
import lombok.Setter;
import sparta.sparta_spring_level_1.entity.Post;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class PostRequest {
    @NotEmpty(message = "제목을 적어 주셔야 합니다.")
    private String title;

    private String content;

    @NotEmpty(message = "닉네임을 적어 주셔야 합니다.")
    private String author;

    @NotEmpty(message = "비밀번호를 적어 주셔야 합니다.")
    private String password;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .password(password)
                .build();
    }
}