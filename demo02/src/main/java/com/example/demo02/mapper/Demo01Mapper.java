package com.example.demo02.mapper;

import com.example.demo02.commom.resp.ApiResp;
import com.example.demo02.model.Demo01;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author AutoCoder
 * @since 2021-04-10
 */
public interface Demo01Mapper extends BaseMapper<Demo01> {

    @Select("select * from demo01 where username = #{username} and password = #{password}")
    public  Demo01 isRegistration(@Param("username") String Username,@Param("password") String password);

    @Insert("insert into demo01(username,password,sex,phone,age) values(#{username},#{password},#{sex},#{phone},#{age})")
    public int addUser(@Param("username") String username, @Param("password") String password, @Param("sex") boolean sex, @Param("phone") String phone, @Param("age") int age);

    @Select("select * from demo01 where username=#{username}")
    public Demo01 selectMessage(@Param("username") String username);

    @Select("select * from demo01")
    public List<Demo01> message();
}
