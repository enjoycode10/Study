package com.okgo.jwt.service;

import com.okgo.jwt.entity.User;
import com.okgo.jwt.result.ResultDTO;
import com.okgo.jwt.result.ResultError;
import com.okgo.jwt.result.UserError;
import com.okgo.jwt.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Shawn
 * @date 2020/7/5 2:32
 * @title Function
 */
@Service("UserService")
@Slf4j
public class UserService {

    public static final User user = new User("1", "shawn", "123456");

    public String login(String name, String password) {
        String token = null;
        try {

            //检验用户密码是否正确
            if(user.getPassword().equals(password) && user.getUsername().equals(name)){
                // 生成token，将 user id 、userName保存到 token 里面
                token = JwtUtil.sign(user.getUsername(),user.getId(),user.getPassword());
            }else {
                ResultDTO.failure(new ResultError(UserError.EMP_IS_NULL_EXIT));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
