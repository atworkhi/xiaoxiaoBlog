package com.hanxx.springboot.controller;

import com.hanxx.springboot.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:20 2017/11/6
 * @Description:
 * <p> 管理员控制器
 * <p>
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
    /**
     * 获取后台管理的页面
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView listUser(Model model){
        List<Menu> list = new ArrayList<>();
        list.add(new Menu("用户管理", "/users"));
        list.add(new Menu("角色管理", "/roles"));
        list.add(new Menu("博客管理", "/blogs"));
        list.add(new Menu("评论管理", "/commits"));
        model.addAttribute("list", list);
        return new ModelAndView("admins/index","menuList",model);
    }
}
