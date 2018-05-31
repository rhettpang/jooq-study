package com.pk.controller;

import com.pk.JooqClient;
import com.pk.db.gen.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Created by pangkunkun on 2018/5/31.
 */
@RestController
public class UserController {

    @Autowired
    private JooqClient jooqClient;

    @GetMapping("/users")
    public List<UserInfo> getUsers(){
        return jooqClient.getUsers();
    }

}
