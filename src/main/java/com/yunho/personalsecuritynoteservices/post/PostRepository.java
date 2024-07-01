package com.yunho.personalsecuritynoteservices.post;

import java.util.List;

import com.yunho.personalsecuritynoteservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserOrderByIdDesc(User user);

    Post findByIdAndUser(Long id, User user);
}
