package cn.mafangui.topdeckgo.controller;

import cn.mafangui.topdeckgo.entity.User;
import cn.mafangui.topdeckgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
    @PostMapping(value = "/isUserNameExist")
    public int confirmUser(String userName){
        if(userService.getUserByUserName(userName) != null){
            return -1;
        }
        return 0;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @PostMapping(value = "/login")
    public int login(String userName,String password){
        return userService.login(userName,password);
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public int registerUser(User user){
        return userService.register(user);
    }
}
