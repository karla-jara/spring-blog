package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsRepository extends JpaRepository <Ad, Long> {

    Ad findByTitle(String title);
    Ad findByTitleLike(String searchPattern); //find by title "%input%"

    List<Ad> searchByTitle(String term);
}
