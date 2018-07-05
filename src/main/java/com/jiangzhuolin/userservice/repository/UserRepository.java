package com.jiangzhuolin.userservice.repository;

import com.jiangzhuolin.userservice.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User save(User user);

    User findUserById(long id);

    @Override
    Page<User> findAll(Pageable pageable);
}
