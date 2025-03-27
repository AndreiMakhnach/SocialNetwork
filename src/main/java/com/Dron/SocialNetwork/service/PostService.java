package com.Dron.SocialNetwork.service;

import com.Dron.SocialNetwork.entity.Post;
import com.Dron.SocialNetwork.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(Post post) {
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> getPostsByUser(String userId) {
        return postRepository.findByAuthorId(userId);
    }

    // Удаление поста
    public void deletePost(String postId) {
        postRepository.deleteById(postId);
    }

    // Пагинация с сортировкой по дате
    public Page<Post> getPostsPage(int page, int size) {
        return postRepository.findAll(
                PageRequest.of(page, size, Sort.by("createdAt").descending())
        );
    }
}
