package sparta.sparta_spring_level_1.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter @Setter
@Builder
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime postDate;

    @Enumerated(EnumType.STRING)
    private PostStatus  postStatus;

    public Post() {

    }

    public static Post createPost(Post post) {
        post.setPostDate(LocalDateTime.now());
        post.setPostStatus(PostStatus.PUBLISHED);
        return post;
    }

    public void delete() {
        this.setPostStatus(PostStatus.DELETED);
    }
}