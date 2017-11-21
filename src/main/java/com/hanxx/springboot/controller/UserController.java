package com.hanxx.springboot.controller;

import com.hanxx.springboot.domain.Authority;
import com.hanxx.springboot.domain.User;
import com.hanxx.springboot.service.AuthorityService;
import com.hanxx.springboot.service.UserService;
import com.hanxx.springboot.util.MyException;
import com.hanxx.springboot.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 16:23 2017/11/6
 * @Description: <p>
 * <p>
 */
@RestController
@RequestMapping("/users")
//指定角色权限才能访问
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;
    /**
     * 获取所有用户
     * @param async 异步分页
     * @param pageIndex 页数
     * @param pageSize 每页数量
     * @param name 查询条件 用户名
     * @return
     */
    @GetMapping
    public ModelAndView list(@RequestParam(value = "async",required = false)boolean async,
                             @RequestParam(value = "pageIndex",required = false,defaultValue = "0")int pageIndex,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "10")int pageSize,
                             @RequestParam(value = "name",required = false,defaultValue = "")String name,
                             Model model) {

        Pageable pageable=new PageRequest(pageIndex,pageSize);
        Page<User> page=userService.listUsersByNameLike(name,pageable);
        //获取内容
        List<User> list=page.getContent();

        model.addAttribute("page",page);
        model.addAttribute("userList",list);
        //返回 url 模块名称 模型
        return new ModelAndView(async==true?"users/list::#mainContainerRepleace":"users/list","userModel",model);
    }

    /**
     * 获取form表单
     * @param model user
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User(null,null,null,null));
        return new ModelAndView("users/add","userModel",model);
    }


    //添加用户
    @PostMapping
    public ResponseEntity<Response> addUser(User user,Long authorityId){
        List<Authority> authorities=new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(authorityId));
        user.setAuthorities(authorities);
        if(user.getId()==null){
            //对密码进行加密
            user.setEncodePassword(user.getPassword());

        }else{
            //判断密码是否做出了改变
            User originalUser=userService.getUserById(user.getId());
            String rawpassword=originalUser.getPassword();
            //System.out.println("originalUser：=="+user.getPassword());
            PasswordEncoder encoder=new BCryptPasswordEncoder();
            String encodepassword=encoder.encode(user.getPassword());
            //System.out.println("encodepassword：=="+user.getPassword());
            boolean ismath=encoder.matches(rawpassword,encodepassword);

            if(!ismath){

                user.setEncodePassword(user.getPassword());
                //System.out.println("变更后的：=="+user.getPassword());
            }else{
                user.setPassword(user.getPassword());
            }
        }
        try {
            userService.saveUser(user);
        }catch (ConstraintViolationException e){
            return ResponseEntity.ok().body(new Response(false,MyException.getMessage(e)));
        }
        return ResponseEntity.ok().body(new Response(true, "处理成功", user));
    }

    /**
     * 删除用户
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id")Long id,Model model){
        try {
            userService.removeUser(id);
        }catch (Exception e){
            return  ResponseEntity.ok().body( new Response(false, e.getMessage()));
        }

        System.out.println(id);
        return  ResponseEntity.ok().body( new Response(true, "处理成功"));
    }

    /**
     * 获取修改用户的界面，及数据
     * @param
     * @return
     */
    @GetMapping(value = "edit/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return new ModelAndView("users/edit", "userModel", model);
    }

}
