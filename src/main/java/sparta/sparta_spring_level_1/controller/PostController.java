package sparta.sparta_spring_level_1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sparta.sparta_spring_level_1.Entity.Post;
import sparta.sparta_spring_level_1.dto.PostResponse;
import sparta.sparta_spring_level_1.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/create")
    public PostResponse createPost(@RequestBody Post post) {
        return null;
    }
}
