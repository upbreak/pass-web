package com.jinwoo.pass.passweb.dto;

import com.jinwoo.pass.passweb.dto.type.UserStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private String userId;
    private String userName;
    private UserStatus status;
}
