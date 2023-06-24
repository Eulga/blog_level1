package sparta.sparta_spring_level_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import sparta.sparta_spring_level_1.dto.PostRequest;
import sparta.sparta_spring_level_1.dto.PostResponse;
import sparta.sparta_spring_level_1.entity.Post;
import sparta.sparta_spring_level_1.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 생성
    public PostResponse createPost(@RequestBody PostRequest postRequest) {
        Post savePost = postRequest.toEntity();
        Post post = postRepository.save(savePost);
        return new PostResponse(post);
    }

    // 전체 조회
    public List<PostResponse> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponse::new).collect(Collectors.toList());
    }

    // 게시글 id로 조회
    public PostResponse getPostsById(Long id) {
        Post post = findPost(id);

        return new PostResponse(post);
    }

    // 수정
    public Long updatePost(Long id, PostRequest postRequest) {
        Post post = findPost(id);

        post.update(postRequest);

        return post.getId();
    }

    // 삭제
    public Long deletePost(Long id) {
        Post post = findPost(id);

        postRepository.delete(post);

        return id;
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
