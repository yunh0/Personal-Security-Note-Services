package com.yunho.personalsecuritynoteservices.post;

import java.util.List;

import com.yunho.personalsecuritynoteservices.user.User;
import com.yunho.personalsecuritynoteservices.user.UserNotFoundException;
import com.yunho.personalsecuritynoteservices.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findByUser(User user) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (user.isAdmin()) {
            return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        }
        return postRepository.findByUserOrderByIdDesc(user);
    }

    public Post savePost(User user, String title, String content) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        return postRepository.save(new Post(title, content, user));
    }

    public void deletePost(User user, Long postId) {
        if (user == null) {
            throw new UserNotFoundException();
        }
        Post post = postRepository.findByIdAndUser(postId, user);
        postRepository.delete(post);
    }
}
