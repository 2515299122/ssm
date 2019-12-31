package wubing.ssm_pro.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wubing.ssm_pro.dao.PermissionDao;
import wubing.ssm_pro.domain.Permission;
import wubing.ssm_pro.service.PermissonService;

import javax.jnlp.PersistenceService;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissonService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll(int page, int pageSize) throws Exception {
        PageHelper.startPage(page,pageSize);
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
