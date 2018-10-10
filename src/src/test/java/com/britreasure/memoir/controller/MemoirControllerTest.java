package com.britreasure.memoir.controller;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.Memoir;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午7:26
 */
public class MemoirControllerTest extends JunitBaseTest {
    @Autowired
    private MemoirController memoirController;

    @Test
    public void getAllMemoirTest() {
        Assert.assertTrue(memoirController.getAllMemoir().size() > 0);
    }

    @Test
    public void addMemoirTest() {
        Memoir memoir = new Memoir();
        memoir.setTitle("hellokitty");
        memoir.setMark("hellokitty mark");
        Memoir addMemoir = memoirController.addMemoir(memoir);
        Assert.assertNotNull(addMemoir.getId());
        Assert.assertEquals("hellokitty", addMemoir.getTitle());
    }

    @Test
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
    public void removeMemoirTest() {
        Memoir memoir = new Memoir();
        memoir.setTitle("hellokitty");
        memoir.setMark("hellokitty mark");
        Memoir addMemoir = memoirController.addMemoir(memoir);
        Memoir deleteMemoir = memoirController.removeMemoir(addMemoir.getId());
        Assert.assertNotNull(deleteMemoir.getId());
    }
}
