package sparta.sparta_spring_level_1.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sparta.sparta_spring_level_1.Entity.Post;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager em;

    public Post save(Post post) {
        if(post.getId() == null) em.persist(post);
        else em.merge(post);

        return findOne(post.getId());
    }

    public Post findOne(Long id) {
        return em.find(Post.class, id);
    }

}