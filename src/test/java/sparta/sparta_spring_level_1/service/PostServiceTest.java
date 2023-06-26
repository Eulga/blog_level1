package sparta.sparta_spring_level_1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import sparta.sparta_spring_level_1.dto.PostRequest;
import sparta.sparta_spring_level_1.entity.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class PostServiceTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @DisplayName("게시글 저장")
    void createPost() {
        PostRequest postRequest = new PostRequest();
        postRequest.setTitle("title");
        postRequest.setAuthor("이름");
        postRequest.setContent("content");
        postRequest.setPassword("1234");

        Post post = postRequest.toEntity();
        em.persist(post);
    }

    @Test
    void getPosts() {
    }

    @Test
    void getPostById() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePost() {
    }
}