package com.nestdigital.twitter_backend.controller;

import com.nestdigital.twitter_backend.dao.SignUpDao;
import com.nestdigital.twitter_backend.model.SignUpModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignUpController {

    @Autowired
    private SignUpDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup", consumes = "application/json",produces = "application/json")
    public String signUp(@RequestBody SignUpModel signup)
    {
        dao.save(signup);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login" ,consumes = "application/json", produces = "application/json")
    public List<SignUpModel> Login(@RequestBody SignUpModel signup)
    {
        return (List<SignUpModel>) dao.Signup(signup.getEmail(),signup.getPassword());
    }
}
