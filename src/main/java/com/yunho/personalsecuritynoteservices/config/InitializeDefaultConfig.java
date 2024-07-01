package com.yunho.personalsecuritynoteservices.config;

import com.yunho.personalsecuritynoteservices.notice.NoticeService;
import com.yunho.personalsecuritynoteservices.note.NoteService;
import com.yunho.personalsecuritynoteservices.user.User;
import com.yunho.personalsecuritynoteservices.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
@Profile(value = "!test")
public class InitializeDefaultConfig {

    private final UserService userService;
    private final NoteService noteService;
    private final NoticeService noticeService;

    @Bean
    public void initializeDefaultUser() {
        User user = userService.signup("user", "user");
        noteService.saveNote(user, "테스트", "테스트입니다.");
        noteService.saveNote(user, "테스트2", "테스트2입니다.");
        noteService.saveNote(user, "테스트3", "테스트3입니다.");
        noteService.saveNote(user, "여름 여행계획", "여름 여행계획 작성중...");
    }

    @Bean
    public void initializeDefaultAdmin() {
        userService.signupAdmin("admin", "admin");
        noticeService.saveNotice("환영합니다.", "환영합니다 여러분");
        noticeService.saveNotice("노트 작성 방법 공지", "1. 회원가입\n2. 로그인\n3. 노트 작성\n4. 저장\n* 본인 외에는 게시글을 볼 수 없습니다.");
    }
}
