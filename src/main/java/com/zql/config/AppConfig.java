package com.zql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Administrator on 2017/9/5.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.zql.app")
public class AppConfig {



}
