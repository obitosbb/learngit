package com.example.demo02.service;

import com.example.demo02.commom.resp.ApiResp;
import com.example.demo02.model.Demo01;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author AutoCoder
 * @since 2021-04-10
 */

public interface IDemo01Service extends IService<Demo01> {
    //int addUser(String username,String password,String sex,String phone,int age);
    Demo01 isRegistration(String username,String password);

    ApiResp addUser(String username, String password, boolean sex, String phone, int age);

    Demo01 selectMessage(String username);

    boolean isUsername(String username);
    boolean isPassword(String password);
    boolean isPhone(String phone);
    boolean isAge(int age);

    List<Demo01> message();
}