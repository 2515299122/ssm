package wubing.ssm_pro.controller;



import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wubing.ssm_pro.domain.Product;
import wubing.ssm_pro.service.ProductService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //查询所有产品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll(page,pageSize);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }
    //根据id查询产品
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id") String id){
        ModelAndView mv = new ModelAndView();
        Product product=productService.findById(id);
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }
    //添加产品
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/save.do")
    public void save(Product product, HttpServletRequest request, HttpServletResponse response)throws Exception{
        productService.save(product);
        response.sendRedirect(request.getContextPath()+"/product/findAll.do");
    }
    //编辑产品
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/update.do")
    public String update(Product product){
        productService.update(product);
        return "redirect:findAll.do";
    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/changeStatus.do")
    public String changeStatus(@RequestParam(name = "ids") List<String> list,@RequestParam(name="productStatus") Integer productStatus){
        productService.changeStatus(list,productStatus);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(productStatus);
        return "redirect:findAll.do";
    }
}
