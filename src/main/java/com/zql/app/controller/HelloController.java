package com.zql.app.controller;

import com.zql.app.entity.Bag;
import com.zql.app.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/5.
 */
@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @PreAuthorize("principal.username=='zql'")
    @RequestMapping("/zql")
    public void zqlOnly(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        logger.info("user has authorize zql");
    }


    @RequestMapping("/user")
    public User user(){
        User user = new User();
        Bag bag = new Bag();
        ArrayList<String> books = new ArrayList<>();
        books.add("哈弗中国史");
        books.add("巨婴国");
        books.add("人类简史");
        books.add("麦克阿瑟");
        bag.setBooks(books);
        user.setBag(bag);
        user.setAge(12);
        user.setMoney(123.1);
        user.setName("jason");
        user.setSexual(false);
        return user;
    }

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    public String foo(){
       return "foo";
    }

    @RequestMapping(value = "foo/{bar}",method = RequestMethod.GET)
    public String bar(@PathVariable String bar){
        return "hello,"+bar;
    }

    @RequestMapping(value = "secret")
    public String secret(){
        return "secret method";
    }


}
