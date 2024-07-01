package com.yunho.personalsecuritynoteservices.post;

import java.util.List;

import com.yunho.personalsecuritynoteservices.user.User;
import com.yunho.personalsecuritynoteservices.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findByUserName(String userName) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new RuntimeException("유저가 없습니다.");
        }
        return postRepository.findByUserAndStatus(user, PostStatus.Y);
    }

    public Post savePost(String userName, String title, String content) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new RuntimeException("유저가 없습니다.");
        }
        return postRepository.save(new Post(title, content, user));
    }

    public void deletePost(String userName, Long id) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new RuntimeException("유저가 없습니다.");
        }
        Post post = postRepository.findByIdAndUser(id, user);
        postRepository.delete(post);
    }
}
