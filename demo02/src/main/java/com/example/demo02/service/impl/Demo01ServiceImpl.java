package com.example.demo02.service.impl;


import com.example.demo02.commom.resp.ApiResp;
import com.example.demo02.model.Demo01;
import com.example.demo02.mapper.Demo01Mapper;
import com.example.demo02.service.IDemo01Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author AutoCoder
 * @since 2021-04-10
 */

@Service
public class Demo01ServiceImpl extends ServiceImpl<Demo01Mapper, Demo01> implements IDemo01Service {

    //帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
    public boolean isUsername(String username){
        String pattern = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(username);

        return m.matches();
    }

    //强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在 8-10 之间)
    public boolean isPassword(String password){
        String pattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,10}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(password);

        return m.matches();
    }

    //手机号码
    public boolean isPhone(String phone){
        String pattern = "^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(phone);

        return m.matches();
    }

    public boolean isAge(int age){
        if(age>1&&age>150){
            return false;
        }
        return true;
    }

    public List<Demo01> message(){
        return  baseMapper.message();
    }

    //是否已经注册
    public Demo01 isRegistration(String username,String password){

        password=MessageDigest5.interfaceMd5(password,"utf-8");
        return baseMapper.isRegistration(username, password);
    }

    //增加用户
    public ApiResp addUser(String username, String password, boolean sex, String phone, int age){

        password=MessageDigest5.interfaceMd5(password,"utf-8");
        String inputSpecification;

        if(!isUsername(username)){
            System.out.println("-------------用户名规范-------------");
            return ApiResp.inputSpecification("用户名不符合规范");
        }
//        if(!isPassword(password)){
//            return ApiResp.inputSpecification("密码不符合规范");
//        }
        if(!isPhone(phone)){
            return ApiResp.inputSpecification("电话号码不符合规范");
        }
        if(!isAge(age)){
            return ApiResp.inputSpecification("年龄不符合规范");
        }
        else{
            baseMapper.addUser(username,password,sex,phone,age);
            return ApiResp.inputSpecification("注册信息符合规范");
        }
    }

    //查询用户信息
    public  Demo01 selectMessage(String username){
        return baseMapper.selectMessage(username);
    }


}

