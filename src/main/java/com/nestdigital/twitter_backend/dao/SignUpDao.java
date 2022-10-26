package com.nestdigital.twitter_backend.dao;

import com.nestdigital.twitter_backend.model.SignUpModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignUpDao extends CrudRepository<SignUpModel,Integer> {
    @Query(value = "SELECT `id`, `dob`, `email`, `mobile`, `name`, `password`, `place` FROM `users` WHERE `email`= :email  AND`password`= :password",nativeQuery = true)
    List<SignUpModel> Signup(String email ,String password);
}
