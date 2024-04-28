package com.gdb.cloud.responseResult;

import lombok.Getter;

import java.util.Arrays;

/**
 * 异常处理枚举类
 *
 * @author Mr.Gui
 */
@Getter
public enum ResponseEnum {

    // 数据操作定义
    SUCCESS(200, "success"),
    RC500(500, "系统异常，请稍后重试"),
    RC400(400, "参数异常"),
    ERROR(0, "error");

    /**
     * 错误码
     */
    private final Integer resultCode;

    /**
     * 错误描述
     */
    private final String resultMsg;

    ResponseEnum(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    /**
     * 遍历所有的枚举值
     *
     * @param code 状态码
     * @return 返回对应的枚举值
     */
    public static ResponseEnum getResponseEnumV1(Integer code) {
        for (ResponseEnum ele : ResponseEnum.values()) {
            if (ele.getResultCode().equals(code)) {
                return ele;
            }
        }
        return null;
    }

    /**
     * 枚举所有的枚举值
     *
     * @param code 状态码
     * @return 返回对应的枚举值
     */
    public static ResponseEnum getResponseEnumV2(Integer code) {
        return Arrays.stream(ResponseEnum.values()).filter(x -> x.getResultCode().equals(code)).findFirst().orElse(null);
    }

}
