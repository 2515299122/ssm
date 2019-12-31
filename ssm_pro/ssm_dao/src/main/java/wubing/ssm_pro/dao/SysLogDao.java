package wubing.ssm_pro.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import wubing.ssm_pro.domain.SysLog;

import java.util.List;

public interface SysLogDao {


    //@Insert( "insert into sysLog(id,ip) values('1','12')")
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void save(SysLog sysLog) throws Exception;

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;
}
