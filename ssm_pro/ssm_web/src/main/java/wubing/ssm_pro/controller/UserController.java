package wubing.ssm_pro.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import wubing.ssm_pro.domain.Role;
import wubing.ssm_pro.domain.UserInfo;
import wubing.ssm_pro.service.UserService;
import wubing.ssm_pro.utils.BCryptPasswordEncoderUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/saveInfo.do")
    public ModelAndView saveInfo() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserInfo userInfo = userService.findByUsername(name);
        //System.out.println("session中的用户:"+userInfo);
        request.getSession().setAttribute("userInfo",userInfo);
        return mv;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list=userService.findAll(page,pageSize);
        mv.setViewName("user-list");
        PageInfo<Object> pageInfo = new PageInfo(list);
        mv.addObject("userList",pageInfo);
        return mv;
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user=userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user=userService.findById(id);
        List<Role> list=userService.findOtherRoles(id);
        mv.addObject("user",user);
        mv.addObject("roleList",list);
        mv.setViewName("user-role-add");
        return mv;
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name="ids",required = true) String[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
    //修改个人信息
    @RequestMapping(value = "/changeMe.do",method = RequestMethod.POST)
    public String changeMe(UserInfo userInfo)throws Exception{
        userInfo.setIcon("/img/"+userInfo.getIcon()+".jpg");
        System.out.println(userInfo);
        userService.update(userInfo);
        return "redirect:saveInfo.do";
    }
}
