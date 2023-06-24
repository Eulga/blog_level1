package sparta.sparta_spring_level_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sparta.sparta_spring_level_1.entity.Post;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}
