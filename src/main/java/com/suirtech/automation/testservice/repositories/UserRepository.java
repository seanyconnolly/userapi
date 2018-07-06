package com.suirtech.automation.testservice.repositories;

import com.suirtech.automation.testservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserRepository extends CrudRepository<User, String> {
    User findByUserName(String userName);

    List<User> findByFirstName(String firstName);
    List<User> findAll();

    int deleteById(Long id);

    User findById(Long id);


}

