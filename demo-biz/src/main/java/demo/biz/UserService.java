package demo.biz;

import demo.dal.entity.User;
import demo.dal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> find() {
        return userMapper.findAll();
    }
}
