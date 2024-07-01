package com.yunho.personalsecuritynoteservices.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRegisterDto {

    private String username;
    private String password;
}
