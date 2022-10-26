package com.nestdigital.twitter_backend.dao;

import com.nestdigital.twitter_backend.model.PostsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostsDao extends CrudRepository<PostsModel,Integer> {

    @Query(value = "SELECT p.`id`, p.`message`, p.`postdate`, p.`userid`,u.name FROM `posts` p JOIN users u ON u.id=p.userid ",nativeQuery = true)
    List<Map<String,String>>ViewAllPosts();

    @Query(value = "SELECT p.`id`, p.`message`, p.`postdate`, p.`userid`,u.name FROM `posts` p JOIN users u ON u.id=p.userid WHERE p.`userid`= :userid",nativeQuery = true)
    List<Map<String,String>>Individual(int userid);

}
