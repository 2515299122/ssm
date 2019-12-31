package wubing.ssm_pro.service;

import wubing.ssm_pro.domain.Permission;

import java.util.List;

public interface PermissonService {
    List<Permission> findAll(int page, int pageSize) throws Exception;

    void save(Permission permission);
}
