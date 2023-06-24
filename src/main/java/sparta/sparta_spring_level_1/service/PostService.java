package sparta.sparta_spring_level_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.sparta_spring_level_1.Entity.Post;
import sparta.sparta_spring_level_1.dto.PostRequest;
import sparta.sparta_spring_level_1.repository.PostRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 생성
    @Transactional
    public void createPost(PostRequest postRequest) {
        Post savedPost = Post.createPost(postRequest.toEntity());
        Post post = postRepository.save(savedPost);

        // 잘 저장됐는지 확인하는 에러 처리?
    }

    // 수정

    // 삭제
}
