package com.gdb.cloud.responseResult;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 自定义数据传输
 * @author Mr.Gui
 */
@Data
public class ResponseResult <T> {
    /**
     * 响应代码
     */
    @Schema(description = "响应状态码")
    private Integer code;

    /**
     * 响应消息
     */
    @Schema(description = "响应说明")
    private String message;

    /**
     * 响应结果
     */
    @Schema(description = "响应内容")
    private T data;

    /**
     * 时间戳
     */
    @Schema(description = "时间戳")
    private Long timestamp;

    public ResponseResult(){
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功
     */
    public static <H> ResponseResult<H> success(H data) {
        ResponseResult<H> responseResult = new ResponseResult<>();
        responseResult.setCode(ResponseEnum.SUCCESS.getResultCode());
        responseResult.setMessage(ResponseEnum.SUCCESS.getResultMsg());
        responseResult.setData(data);
        return responseResult;
    }

    /**
     * 失败
     */
    public static <H> ResponseResult<H> error(Integer code, String message) {
        ResponseResult<H> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        responseResult.setData(null);
        return responseResult;
    }

}
