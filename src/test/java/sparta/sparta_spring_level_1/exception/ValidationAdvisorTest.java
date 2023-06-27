package sparta.sparta_spring_level_1.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import sparta.sparta_spring_level_1.repository.PostRepository;

@DataJpaTest
class ValidationAdvisorTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    @DisplayName("Bad id error")
    void createPost() {
        postRepository.findById(3L).orElseThrow(() -> new IllegalArgumentException("not found a post"));
    }
}