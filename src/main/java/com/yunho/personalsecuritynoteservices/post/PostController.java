package com.yunho.personalsecuritynoteservices.post;

import java.util.List;

import com.yunho.personalsecuritynoteservices.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String getPost(Authentication authentication, Model model) {
        User user = (User) authentication.getPrincipal();
        List<Post> posts = postService.findByUser(user);
        model.addAttribute("posts", posts);
        return "post/index";
    }

    @PostMapping
    public String savePost(Authentication authentication, @ModelAttribute PostRegisterDto postRegisterDto) {
        User user = (User) authentication.getPrincipal();
        postService.savePost(user, postRegisterDto.getTitle(), postRegisterDto.getContent());
        return "redirect:post";
    }

    @DeleteMapping
    public String deletePost(Authentication authentication, @RequestParam Long id) {
        User user = (User) authentication.getPrincipal();
        postService.deletePost(user, id);
        return "redirect:post";
    }
}
