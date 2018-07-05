package weile;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BooterTest {


    private static final Logger logger = LoggerFactory.getLogger(BooterTest.class);

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。



    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext


    @Test
        public void contextLoads() {

        }

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }



    @Test
    public void testQ1() throws Exception {

        MvcResult result = mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andReturn();// 返回执行请求的结果

        logger.info("result:{}",result.getResponse().getContentAsString());

    }





}
