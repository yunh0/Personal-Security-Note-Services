package com.yunho.personalsecuritynoteservices.note;

import java.util.List;

import com.yunho.personalsecuritynoteservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserOrderByIdDesc(User user);

    Note findByIdAndUser(Long id, User user);
}
