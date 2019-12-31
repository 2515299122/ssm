package wubing.ssm_pro.dao;

import org.apache.ibatis.annotations.*;
import wubing.ssm_pro.domain.Permission;
import wubing.ssm_pro.domain.Role;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "wubing.ssm_pro.dao.PermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserId(String userId)throws Exception;
    @Select("select * from role")
    List<Role> findAll()throws Exception;
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "wubing.ssm_pro.dao.PermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{id})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("id") String id);
}
