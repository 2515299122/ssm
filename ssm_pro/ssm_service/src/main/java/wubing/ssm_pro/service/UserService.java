package wubing.ssm_pro.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import wubing.ssm_pro.domain.Role;
import wubing.ssm_pro.domain.UserInfo;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page,Integer pageSize) throws Exception;

    void save(UserInfo userInfo)throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String id);

    void addRoleToUser(String userId, String[] ids) throws Exception;

    UserInfo findByUsername(String name) throws Exception;

    void update(UserInfo userInfo);
}
