package com.example.demo02.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author AutoCoder
 * @since 2021-04-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Demo01 extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    //@Resource
    @Autowired
    private String username;
    @Autowired
    private String password;
    @Autowired
    private int age;
    @Autowired
    private boolean sex;
    @Autowired
    private String phone;

}
