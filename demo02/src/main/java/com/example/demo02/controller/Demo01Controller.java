package com.example.demo02.controller;


import com.example.demo02.commom.resp.ApiResp;
import com.example.demo02.model.Demo01;
import com.example.demo02.service.IDemo01Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author AutoCoder
 * @since 2021-04-10
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class Demo01Controller {

    @Resource
    private  IDemo01Service demo01Service;

    @GetMapping("/message")
    public List<Demo01> message(){

        List<Demo01> demo01 = demo01Service.message();
        return demo01;
    }

    @PostMapping("/userMessage")
    public ApiResp userMessage(@RequestBody Demo01 demo01){

        demo01 = demo01Service.selectMessage(demo01.getUsername());
        return demo01 == null ?  ApiResp.failResp("查询失败"):ApiResp.successResp("查询成功",demo01);
    }


    @PostMapping("/login")
    public  ApiResp login(@RequestBody Demo01 demo01){

        Demo01  demo011 = demo01Service.isRegistration(demo01.getUsername(),demo01.getPassword());
        //log.info("[Demo01Controller.serverStart] demo011 = {}",JSON.toJSONString(demo011));

        if(null == demo011){
            //log.info("[Demo01Controller.serverStart] 登陆失败");
            return ApiResp.failResp("登陆失败");
        }

        demo011.setPassword("");
        return ApiResp.successResp("登陆成功",demo011);
    }


    @PostMapping("/registration")
    public ApiResp registration(@RequestBody Demo01 demo01){

        //int demo011 = demo01Service.addUser(demo01.getUsername(),demo01.getPassword(), demo01.isSex(), demo01.getPhone(),demo01.getAge());
        //return demo011 == 0 ? ApiResp.repuestMessage(false,"400","注册失败",demo011):ApiResp.repuestMessage(true,"200","注册成功",demo011);

        ApiResp demo011 = demo01Service.addUser(demo01.getUsername(),demo01.getPassword(), demo01.isSex(), demo01.getPhone(),demo01.getAge());

        return demo011;
    }

}
