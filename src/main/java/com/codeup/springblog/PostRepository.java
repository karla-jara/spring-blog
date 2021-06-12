package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long>{

    Post findByTitle(String title); // find by title (exacts)
    Post findByTitleLike(String searchPattern); // find by title "%input%"
    Post findPostsByBodyContaining(String searchPattern); // find by the "%input%"
    Post deletePostByTitle(String title); // delete by title
    Post saveEditPost(Long id); // update and save

}
