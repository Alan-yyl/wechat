package cn.alan.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨亚龙
 * @date 2020/3/22 1:52
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String Test(){
        System.out.println("TestController.Test");
        return "success";
    }
}
