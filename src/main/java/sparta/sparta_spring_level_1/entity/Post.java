package sparta.sparta_spring_level_1.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sparta.sparta_spring_level_1.dto.PostRequest;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor
@Builder
public class Post extends Timestamped{

    @Id @GeneratedValue
    @Column(name = "post_id", columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    private String title;
    private String content;
    private String author;
    private String password;

    public Post(Long id, String title, String content, String author, String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public void update(PostRequest postRequest) {
        this.content = postRequest.getContent();
    }
}