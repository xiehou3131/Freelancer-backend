package com.freelancer.freelancer.dao;

import com.freelancer.freelancer.entity.Work;

import java.util.List;

public interface WorkDao {
    public Work findByTitle(String title);
    public void save(Work work);
}
