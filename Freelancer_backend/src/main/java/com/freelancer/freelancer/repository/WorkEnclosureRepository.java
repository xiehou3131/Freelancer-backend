package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.WorkEnclosure;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface WorkEnclosureRepository extends MongoRepository<WorkEnclosure, Integer> {

}
