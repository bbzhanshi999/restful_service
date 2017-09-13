package com.zql.config;

import com.zql.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import javax.sql.DataSource;

/**
 * spring security config demo with
 * Created by Administrator on 2017/9/8.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,jsr250Enabled = true,prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用内存验证
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        //使用数据库验证
       /* auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true from user where username=?")
                .authoritiesByUsernameQuery("select username,role_user from user where username=?")
                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));*/
        auth.userDetailsService(userService);
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login.jsp").loginProcessingUrl("/loginUser")
                .successForwardUrl("/foo").defaultSuccessUrl("/foo")
                .and().rememberMe().tokenValiditySeconds(500000)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login.jsp")
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().authorizeRequests()
                .antMatchers("/login.jsp").permitAll()
                .anyRequest().hasAuthority("ADMIN")
                .and()
                .requiresChannel().antMatchers("/secret").requiresSecure()
                .and().csrf().disable();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
        accessDeniedHandler.setErrorPage("/error");
        return accessDeniedHandler;
    }

}
