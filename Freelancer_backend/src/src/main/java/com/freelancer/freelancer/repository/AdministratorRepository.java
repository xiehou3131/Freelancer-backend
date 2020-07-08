package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {
}
