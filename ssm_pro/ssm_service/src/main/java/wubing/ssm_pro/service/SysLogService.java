package wubing.ssm_pro.service;

import wubing.ssm_pro.domain.SysLog;

import java.util.List;

public interface SysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page,Integer pageSize) throws Exception;
}
