package demo.dal.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;//编号
    private String username;//用户名
    private String password;//密码
}
