package cn.alan.wechat.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 杨亚龙
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
