package com.zero.lab.oauth2.common.response;

import com.zero.lab.oauth2.common.exception.ErrorCodeConst;
import lombok.Data;

import java.io.Serializable;

/**
 * @author geyan
 * @date 2025/8/22
 */
@Data
public class CommonResult<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;


    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(ErrorCodeConst.SUCCESS.getCode());
        result.setMsg(ErrorCodeConst.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }
}
