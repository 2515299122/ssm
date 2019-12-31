package wubing.ssm_pro.dao;


import org.apache.ibatis.annotations.Select;
import wubing.ssm_pro.domain.Member;

public interface MemberDao {

    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
