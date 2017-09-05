package com.zql.app.controller;

import com.zql.app.entity.Bag;
import com.zql.app.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/5.
 */
@RestController
public class HelloController {

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
}
