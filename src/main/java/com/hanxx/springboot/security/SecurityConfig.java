package com.hanxx.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Create With IntelliJ IDEA
 * @Author: HanGX
 * @Date: 12:42 2017/11/8
 * @Description: <p>
 * <p> spring security安全配置
 */
@EnableWebSecurity
//方法级的安全设置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private static final String KEY="hanguoxing‘sblog";

    @Autowired
    private UserDetailsService userDetailsService;

    //密码进行加密
    @Autowired
    private PasswordEncoder passwordEncoder;

    //使用 BCrypt 加密
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider anAuthenticationProvider(){
        DaoAuthenticationProvider auth=new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //都可以访问
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()
                .antMatchers("/h2-console/**").permitAll()//都可以访问h2的数据库
                .antMatchers("/admins/**").hasRole("ADMIN")//需要管理员权限访问admins
                .and()
                .formLogin() //form表单验证
                .loginPage("/login").failureUrl("/login-error")//登陆页面与登陆错误信息页面
                .and()
                .rememberMe().key(KEY)//启用记住我
                .and()
                //处理异常，拒绝访问就重定向到 403 页面
                .exceptionHandling().accessDeniedPage("/403");
        //即用 h2控制台的CSRF验证
        http.csrf().ignoringAntMatchers("/h2-console/**");
        //允许来自同一来源的h2控制台的请求
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * 启用认证信息自动注入
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(anAuthenticationProvider());
    }
}

