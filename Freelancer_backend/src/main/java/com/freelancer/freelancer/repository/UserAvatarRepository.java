package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.UserAvatar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserAvatarRepository extends MongoRepository<UserAvatar, Integer> {

}