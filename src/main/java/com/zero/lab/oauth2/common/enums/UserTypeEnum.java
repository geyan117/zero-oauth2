package com.zero.lab.oauth2.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author geyan
 * @date 2025/8/30
 */


@Getter
@AllArgsConstructor
public enum UserTypeEnum {

    ADMIN(1, "后台管理员"),

    MEMBER(2, "用户");

    private final int id;

    private final String name;
}
