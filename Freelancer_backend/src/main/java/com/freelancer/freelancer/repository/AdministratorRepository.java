package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {

    @Query(value = "from Administrator where name = :name and password = :password")
    Administrator checkAdmin(@Param("name") String name, @Param("password") String password);

}
