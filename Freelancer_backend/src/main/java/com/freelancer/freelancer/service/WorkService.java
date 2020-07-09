package com.freelancer.freelancer.service;

import com.freelancer.freelancer.entity.Work;

import java.util.List;


public interface WorkService {
    public Work findByTitle(String title);
    public void save(Work work);
}
