package wubing.ssm_pro.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wubing.ssm_pro.domain.Orders;
import wubing.ssm_pro.service.OrdersService;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "2") Integer pageSize) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page,pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String OrdersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(OrdersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/save.do")
    public String save(Orders orders){
        ordersService.save(orders);
        return "redirect:findAll.do";
    }

}
