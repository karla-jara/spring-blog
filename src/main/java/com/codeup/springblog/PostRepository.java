package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository <Post, Long>{

    Post findByTitle(String title); // find by title (exacts)
    Post findByTitleLike(String searchPattern); // find by title "%input%"
    Post findPostsByBodyContaining(String searchPattern); // find by the "%input%"
    Post deletePostByTitle(String title); // delete by title
    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.title= :getTitle, p.body= :getBody WHERE p.id= :saveEditId") // query for method function
    void saveEditPost(@Param("saveEditId") Long id, @Param ("getTitle") String title, @Param ("getBody") String body); // update and save


}
