package com.britreasure.memoir;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午6:26
 */
public interface IUserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
