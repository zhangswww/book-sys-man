package com.example.config;

import com.example.service.impl.UserServiceImpl;
import com.example.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = Logger.getLogger(SecurityConfig.class);

    @Bean
    UserDetailsService customUserService() {
        return new UserServiceImpl();
    }

    /**
     * 配置忽略的静态文件，不加的话，登录之前页面的css,js不能正常使用，得登录之后才能正常.
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/css/**", "/data/**", "/fonts/**", "/img/**", "/js/**", "/vendor/**", "/icons-reference/**");
    }
/*

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests()
                .antMatchers("/userlogin").permitAll()//表示此路径所有角色
                .antMatchers("/admins/**").hasAnyRole("ADMIN")//
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/commons/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/**").hasAnyRole("ADMIN","USER");
        //开启自动配置的登录功能
        http.formLogin().usernameParameter("username").passwordParameter("password")//指定登录标签名称
                .loginPage("/userlogin").failureUrl("/loginError").defaultSuccessUrl("/index");//告诉我们发什么请求跳转到登录页面，并不是登录验证的时候走这，这里是指定自己的登录页面的url
//.defaultSuccessUrl("/index")

        http.logout().logoutSuccessUrl("/userlogin");
        //退出成功后去到的页面loginProcessingUrl

        //开启记住我的功能
        http.rememberMe().rememberMeParameter("remeber");//使用自定义记住标签 需要指定标签中的name
        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
        //点击注销会删除cookie
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admins/**").hasAnyRole("ADMIN")
                .antMatchers("/users/**").hasAnyRole("USER")
                .antMatchers("/commons/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login").failureUrl("/login?error").successForwardUrl("/index")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .rememberMe().rememberMeParameter("remeber");
        http.csrf().disable();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService())//user Details Service验证
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence rawPassword) {
                        return MD5Utils.encode((String) rawPassword);
                    }

                    @Override
                    public boolean matches(CharSequence rawPassword, String encodedPassword) {
                        boolean b = encodedPassword.equals(MD5Utils.encode((String) rawPassword));
                        if (b) {
                             logger.info("密码验证成功");
                        } else {
                             logger.info("密码验证失败");
                        }
                        return encodedPassword.equals(MD5Utils.encode((String) rawPassword));
                    }
                });
    }

}
