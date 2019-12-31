package wubing.ssm_pro.service;

import wubing.ssm_pro.domain.Permission;
import wubing.ssm_pro.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll(Integer page,Integer pageSize) throws Exception;

    void save(Role role)throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    Role findById(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
