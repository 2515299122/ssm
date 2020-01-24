package wubing.ssm_pro.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;
import wubing.ssm_pro.domain.Role;
import wubing.ssm_pro.domain.UserInfo;

import java.util.List;

public interface UserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "wubing.ssm_pro.dao.RoleDao.findRoleByUserId"))
    })
    //根据用户名进行查询
    UserInfo findByUsername(String username)throws Exception;

    @Select("select * from users")
    //查询所有用户
    List<UserInfo> findAll()throws Exception;
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    //添加用户
    void save(UserInfo userInfo)throws Exception;
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "wubing.ssm_pro.dao.RoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id)throws Exception;

    @Select("select * from role where id not in (select roleid from users_role where userId=#{id})")
    List<Role> findOtherRoles(String id);
    @Insert("insert into users_role values(#{userId},#{id})")
    void addRoleToUser(@Param("userId") String userId, @Param("id") String id)throws Exception;
    @Update("update users set email=#{email},username=#{username},password=#{password},phoneNum=#{phoneNum},status=#{status},icon=#{icon} where id=#{id}")
    void update(UserInfo userInfo);
}
