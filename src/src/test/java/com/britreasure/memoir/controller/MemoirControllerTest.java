package com.britreasure.memoir.controller;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.Memoir;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午7:26
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class MemoirControllerTest extends JunitBaseTest {
    @Autowired
    private MemoirController memoirController;


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext; // 3

    /**
     * 所有测试方法执行之前执行该方法
     */
    @Before
    public void before() {
        //获取mockmvc对象实例
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 4
    }


    @Test
    @WithMockUser(roles = {"USER"})
    public void getAllMemoirTest() {
        Assert.assertTrue(memoirController.getAllMemoir().size() > 0);
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void addMemoirTest() {
        Memoir memoir = new Memoir();
        memoir.setTitle("hellokitty");
        memoir.setMark("hellokitty mark");
        Memoir addMemoir = memoirController.addMemoir(memoir);
        Assert.assertNotNull(addMemoir.getId());
        Assert.assertEquals("hellokitty", addMemoir.getTitle());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void updateMemoirTest() {
        Memoir memoir = new Memoir();
        memoir.setTitle("hellokitty");
        memoir.setMark("hellokitty mark");
        Memoir addMemoir = memoirController.addMemoir(memoir);
        addMemoir.setTitle("updateHello");
        Memoir updateMemoir = memoirController.updateMemoir(addMemoir.getId(), addMemoir);
        Assert.assertNotNull(updateMemoir.getId());
        Assert.assertEquals("updateHello", updateMemoir.getTitle());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void removeMemoirTest() {
        Memoir memoir = new Memoir();
        memoir.setTitle("hellokitty");
        memoir.setMark("hellokitty mark");
        Memoir addMemoir = memoirController.addMemoir(memoir);
        Memoir deleteMemoir = memoirController.removeMemoir(addMemoir.getId());
        Assert.assertNotNull(deleteMemoir.getId());
    }
}
