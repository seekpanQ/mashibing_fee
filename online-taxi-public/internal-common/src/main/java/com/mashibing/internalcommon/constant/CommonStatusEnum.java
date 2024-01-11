package com.mashibing.internalcommon.constant;

import lombok.Getter;

public enum CommonStatusEnum {

    /**
     * 验证码错误提示：1000-1099
     */
    VERIFICATION_CODE_ERROR(1099, "验证码不正确"),

    /**
     * Token类提示：1100-1199
     */
    TOKEN_ERROR(1199, "token错误"),

    /**
     * 成功
     */
    SUCCESS(1, "success"),
    /**
     * 失败
     */
    FAIL(0, "fail"),

    /**
     * 用户提示：1200-1299
     */
    USER_NOT_EXISTS(1200, "当前用户不存在");

    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
