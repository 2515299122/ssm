package wubing.ssm_pro.controller;

import org.springframework.stereotype.Component;
@Component
public class TestImpl implements Test1 {
    public void show(){
        System.out.println("测试方法执行");
    }
}
