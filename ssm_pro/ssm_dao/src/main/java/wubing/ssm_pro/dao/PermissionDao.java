package wubing.ssm_pro.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import wubing.ssm_pro.domain.Permission;

import java.util.List;

public interface PermissionDao {
    //根据角色id查询权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    //查询所有权限
    @Select("select * from permission")
    public List<Permission> findAll()throws Exception;
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
