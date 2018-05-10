package cn.mafangui.topdeckgo.dao;

import cn.mafangui.topdeckgo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@Component
public interface UserDao {

    /**
     * 新增用户
     * @param user
     */
    @Insert("INSERT INTO t_user(user_id,user_name,password,phone)" +
            " values (#{userId},#{userName},#{password},#{phone})")
    int addUser(User user);

    /**
     *修改用户
     * @param user
     */
    @Update("update t_user set password=#{password},phone=#{phone} " +
            "where user_name = #{userName}")
    int updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from t_user where user_name=#{userName}")
    int deleteUser(int userId);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from t_user where user_name=#{userName}")
    User findByUserName(@Param("userName") String userName);

    /**
     * 根据手机号查用户
     * @param phone
     * @return
     */
    @Select("select * from t_user where phone = #{phone}")
    User findByPhone(@Param("phone") String phone);

    /**
     * 按用户名和手机号查询
     * @param userName
     * @param password
     * @return
     */
    @Select("select * from t_user where user_name=#{userName} and password=#{password}")
    User findByUsernameAndPassword(@Param("userName") String userName,@Param("password") String password);

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from t_user")
    List<User> selectAllUser();
}
