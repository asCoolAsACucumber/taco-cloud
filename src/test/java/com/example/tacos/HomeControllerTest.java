package com.example.tacos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
/**
 * @Author moon
 * @Date 2023/4/6 9:44
 * @Description TODO
 */
@WebMvcTest(HomeController.class)   //针对HomeController的Web测试
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;    //注入MockMvc
    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(get("/"))   //发起对"/"的请求
                .andExpect(status().isOk()) //期望得到HTTP200(OK)状态
                .andExpect(view().name("home")) //期望得到home视图
                .andExpect(content().string(    //期望包含"Welcom to..."
                        containsString("Welcome to...")));
    }
}
