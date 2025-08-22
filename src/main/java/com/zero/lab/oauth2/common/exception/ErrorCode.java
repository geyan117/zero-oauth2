package com.zero.lab.oauth2.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误码对象
 *
 * @author geyan
 * @date 2025/8/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorCode {

    private Integer code;

    private String msg;
}
