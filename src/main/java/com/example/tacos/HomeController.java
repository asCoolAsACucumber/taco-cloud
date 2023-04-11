package com.example.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author moon
 * @Date 2023/4/6 9:25
 * @Description TODO
 */
@Controller //控制器
public class HomeController {
    @GetMapping("/")    //处理对根路径"/"的请求
    public String home() {
        return "home";  //返回视图名
    }
}
