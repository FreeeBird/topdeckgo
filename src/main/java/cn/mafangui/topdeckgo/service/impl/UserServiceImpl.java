package cn.mafangui.topdeckgo.service.impl;

import cn.mafangui.topdeckgo.dao.UserDao;
import cn.mafangui.topdeckgo.entity.User;
import cn.mafangui.topdeckgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        int result =0;
        if(userDao.findByUserName(user.getUserName()) != null){
            result=-1;
        }
        else if (userDao.findByPhone(user.getPhone()) != null){
            result = -2;
        }
        if(result==0){
            result=userDao.addUser(user);
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public int login(String userName, String password) {
        if(userDao.findByUserName(userName) == null){
            return -1;
        }
        else if(userDao.findByUsernameAndPassword(userName,password) == null){
            return -2;
        }
        return 0;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    @Override
    public User getUserByPhone(String phone) {
        return null;
    }
}
