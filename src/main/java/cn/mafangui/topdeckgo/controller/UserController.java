package cn.mafangui.topdeckgo.controller;

import cn.mafangui.topdeckgo.entity.User;
import cn.mafangui.topdeckgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    @Cacheable(value="user-key")
    public User getUser() {
        User user = new User();
        user.setUserId(new Random().nextInt());
        user.setUserName("name");
        user.setPhone("324324");
        user.setPassword("dsa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

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
