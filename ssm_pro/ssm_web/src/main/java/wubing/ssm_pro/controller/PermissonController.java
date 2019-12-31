package wubing.ssm_pro.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wubing.ssm_pro.domain.Permission;
import wubing.ssm_pro.service.PermissonService;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissonController {
    @Autowired
    private PermissonService permissonService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1")Integer page, @RequestParam(defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Permission> list = permissonService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission) {
        permissonService.save(permission);
        return "redirect:findAll.do";
    }
}
