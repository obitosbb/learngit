package com.example.demo02.commom.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResp <T> {

    /**
     * true: 成功的
     * false: 失败的
     */
    private boolean success;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 单纯返回成功响应
     * @return
     */



    public static <T>ApiResp repuestMessage(boolean success,String code,String msg,T data){
        ApiResp apiResp = ApiResp.builder().success(true).code(code).msg(msg).data(data).build();
        return apiResp;
    }





    public static ApiResp successResp(){
        ApiResp apiResp = ApiResp.builder().success(true).build();
        return apiResp;
    }

    public static <T>ApiResp successResp(String msg,T data){
        ApiResp apiResp = ApiResp.builder().success(true).msg(msg).data(data).build();
        return apiResp;
    }

    public static <T>ApiResp successResp(String code,String msg,T data){
        ApiResp apiResp = ApiResp.builder().success(true).code(code).msg(msg).data(data).build();
        return apiResp;
    }






    public static ApiResp failResp(){
        ApiResp apiResp = ApiResp.builder().success(false).build();
        return apiResp;
    }

    public static ApiResp failResp(String msg){
        ApiResp apiResp = ApiResp.builder().success(false).code("1111").msg(msg).build();
        return apiResp;
    }

    public static ApiResp failResp(String code, String msg){
        ApiResp apiResp = ApiResp.builder().success(false).code(code).msg(msg).build();
        return apiResp;
    }

    public static <T>ApiResp failResp(String code,String msg,T data){
        ApiResp apiResp = ApiResp.builder().success(false).code(code).msg(msg).data(data).build();
        return apiResp;
    }


    public static <T>ApiResp inputSpecification(String msg){
        ApiResp apiResp = ApiResp.builder().msg(msg).build();
        return apiResp;
    }
}
