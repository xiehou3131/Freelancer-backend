package com.freelancer.freelancer.repository;

import com.freelancer.freelancer.entity.UserAvatar;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAvatarRepository extends MongoRepository<UserAvatar, Integer> {

}
