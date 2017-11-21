package com.hanxx.springboot.controller;

import com.hanxx.springboot.domain.Authority;
import com.hanxx.springboot.domain.User;
import com.hanxx.springboot.service.AuthorityService;
import com.hanxx.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 15:52 2017/11/6
 * @Description:
 * <p>主页访问权限路径
 * <p>有重定向 不能用@restcontroller
 */
@Controller
public class MainController {
    //普通用户注册为博主权限
    private static final Long ROLE_USER_AUTHORITY_ID=2L;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    //访问根目录 重定向到 index
    @GetMapping("/")
    public String root() {

        return "redirect:/index";
    }

    //访问index
    @GetMapping("/index")
    public String index() {
        return "redirect:/blogs";
    }

    //登陆页面
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //登陆失败
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("message", "登陆失败，账号或者密码错误！");

        return "login";
    }
    //访问403
    @GetMapping("/403")
    public String auth(){
        return "403";
    }
    //注册
    @GetMapping("/register")
    public ModelAndView register(Model model){
        model.addAttribute("usernameException",null);
        return new ModelAndView("register", "usernameModel", model);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ModelAndView registerUser(User user, Model model){
        String username=user.getUsername();
        if(userService.findByUsername(username)!=null){
            model.addAttribute("usernameException","账号已存在，请重新输入");
            System.out.println("账号已存在，请重新输入");
            return new ModelAndView("register", "usernameModel", model);
        }else {
            try {
                List<Authority> authorities = new ArrayList<>();
                //默认新注册用户均为博主权限，不具备管理员权限
                authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
                user.setAuthorities(authorities);
                //对密码进行加密
                PasswordEncoder encoder=new BCryptPasswordEncoder();
                String encodePwd=encoder.encode(user.getPassword());
                user.setPassword(encodePwd);
                userService.saveUser(user);
                model.addAttribute("usernameException","注册成功，请登陆");
                return new ModelAndView("login", "usernameModel", model);
            }catch (Exception e){
                model.addAttribute("usernameException","注册出现错误，请重新填写注册信息");
                return new ModelAndView("register", "usernameModel", model);
            }

        }

    }
    @GetMapping("/search")
    public String search() {
        return "search";
    }

}

