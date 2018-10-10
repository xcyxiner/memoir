package com.britreasure.memoir.repository;

import com.britreasure.memoir.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午6:26
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
