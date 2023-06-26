package sparta.sparta_spring_level_1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sparta.sparta_spring_level_1.dto.PostRequest;
import sparta.sparta_spring_level_1.dto.PostResponse;
import sparta.sparta_spring_level_1.entity.Post;
import sparta.sparta_spring_level_1.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 생성
    public PostResponse createPost(PostRequest postRequest) {
        Post savePost = postRequest.toEntity();
        //비밀번호 암호화

        Post post = postRepository.save(savePost);

        return new PostResponse(post);
    }

    // 전체 조회
    public List<PostResponse> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponse::new).collect(Collectors.toList());
    }

    // 게시글 id로 조회
    public PostResponse getPostById(Long id) {
        Post post = findPost(id);

        return new PostResponse(post);
    }

    // 수정
    @Transactional
    public Long updatePost(Long id, PostRequest postRequest) {
        Post post = findPost(id);
        // 비밀번호 복호화

        if(post.getPassword().equals(postRequest.getPassword())){
            post.update(postRequest);
        } else {
            throw new IllegalArgumentException("Password is wrong");
        }
        return post.getId();
    }

    // 삭제
    public Long deletePost(Long id, String password) {
        Post post = findPost(id);
        // 비밀번호 복호화

        System.out.println("post.getPassword() = " + post.getPassword());
        System.out.println("password = " + password);

        if(post.getPassword().equals(password)){
            postRepository.delete(post);
        } else {
            throw new IllegalArgumentException("Password is wrong");
        }

        return id;
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("선택한 게시글은 존재하지 않습니다.")
        );
    }
}
