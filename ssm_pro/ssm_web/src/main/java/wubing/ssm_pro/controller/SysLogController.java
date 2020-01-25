package wubing.ssm_pro.controller;


import com.github.pagehelper.PageInfo;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wubing.ssm_pro.domain.SysLog;
import wubing.ssm_pro.service.SysLogService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30") Integer pageSize) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<SysLog> sysLogList= sysLogService.findAll(page,pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }

}
