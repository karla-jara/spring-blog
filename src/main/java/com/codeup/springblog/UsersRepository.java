package com.codeup.springblog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Long> {

    User findById(long id);
    User findByEmail(String email);
    User findByUsername(String username);
}
