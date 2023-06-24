package sparta.sparta_spring_level_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import sparta.sparta_spring_level_1.entity.Post;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
