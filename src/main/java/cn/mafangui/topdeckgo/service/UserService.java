package cn.mafangui.topdeckgo.service;

import cn.mafangui.topdeckgo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    int register(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);

    int login(String username,String password);

    List<User> getAllUser();

    User getUserByUserName(String userName);

    User getUserByPhone(String phone);
}
